package com.ivan.eloy.eloysimulator.core.model;

import java.time.LocalDate;

import com.ivan.eloy.eloysimulator.tasks.Task;
import com.ivan.eloy.eloysimulator.tasks.management.TaskModifier;

public abstract class Human {

	protected double experience; 		
	protected double stress;
	protected double frustration;
	protected double satisfaction;
	protected double motivation;
	protected double workAgility;
	protected boolean focus;		// should be activated explicitly
	protected boolean evilMode;   	// is activated when frustration exceeds value 8
	protected boolean alive;
	protected boolean working;
	
	protected TaskModifier taskModifier;
	
	// ######################################################################
	// # GETTERS AND SETTERS
	// ######################################################################
	
	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public double getStress() {
		return stress;
	}

	public void setStress(double stress) {
		this.stress = stress;
	}

	public double getFrustration() {		
		return frustration;
	}

	public void setFrustration(double frustration) {
		this.frustration = frustration;
	}

	public double getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(double satisfaction) {
		this.satisfaction = satisfaction;
	}

	public double getMotivation() {
		return motivation;
	}

	public void setMotivation(double motivation) {
		this.motivation = motivation;
	}
	
	public double getWorkAgility() {
		return workAgility;
	}

	public void setWorkAgility(double workAgility) {
		this.workAgility = workAgility;
	}

	public boolean isFocus() {
		return focus;
	}
	
	public void setFocus(boolean focus) {
		this.focus = focus;
	}

	public boolean isEvilMode() {
		return evilMode;
	}

	public void setEvilMode(boolean evilMode) {
		this.evilMode = evilMode;
	}
	
	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public TaskModifier getTaskModifier() {
		return taskModifier;
	}

	public byte getAge() {
		byte age = 0;

		LocalDate bornDate = LocalDate.of(2000, 10, 7);

		age = (byte)java.time.temporal.ChronoUnit.YEARS.between(bornDate , LocalDate.now());

		return age;
	}
	
	// ######################################################################
	// # PUBLIC METHODS
	// ######################################################################
	
	public void workOn(Task task) {
		if (!working) {
			working = true;
			Thread thread = new Thread(() -> {
				while(task.getCompletedWork() < task.getWorkload()) {
					taskModifier.modifyCompletedWork(0.1, task);
					try {
						System.out.println(	" #!#!#!# task log -- workload " + task.getWorkload() + 
								" workCompleted " + task.getCompletedWork());
						Thread.sleep(Math.round(Byte.MAX_VALUE - workAgility));
					} catch(InterruptedException ie) {
						System.out.println("Se interrumpió la ejecucíon de la tarea " +
											task.getName());
						working = false;
					}
				}
				
				task.setCompletedWork(task.getWorkload());
				try {
					experience += taskModifier.submit(task);
				} catch(Exception ex) {
					System.out.println("¡¡¡ " + ex.getMessage());
				}
				
				working = false;
			});
			
			thread.setName(task.getName() + "TaskThread");
			thread.start();
		} else {
			System.out.println("No puedo, estoy trabajando en " + task.getName());
		}
	}

	// ######################################################################
	// # ABSTRACT METHODS
	// ######################################################################
	
	public abstract void sayHi();
	
	public abstract void talk();
	
	// ######################################################################
	// # INHERITED METHODS IMPLEMENTED
	// ######################################################################
	
	@Override
	public String toString() {
		return  getClass().getSimpleName() 				+ "[\n" +
					"\thashcode = " 	+ hashCode() 	+ ",\n" +
					"\texperience = " 	+ experience 	+ ",\n" +
					"\tstress = " 		+ stress 		+ ",\n" +
					"\tfrustration = " 	+ frustration 	+ ",\n" +
					"\tsatisfaction = " + satisfaction 	+ ",\n" +
					"\tmotivation = " 	+ motivation 	+ ",\n" +
					"\twork agility = "	+ workAgility 	+ ",\n" +
					"\tfocus = " 		+ focus 		+ ",\n" +
					"\tevilMode = " 	+ evilMode 		+ ",\n" +
					"\tworking = " 		+ working		+ ",\n" +
					"\talive = " 		+ alive 		+ "\n" +
				"]";
	}

}
