package com.ivan.moodidk.core.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import com.ivan.moodidk.tasks.Task;
import com.ivan.moodidk.tasks.management.TaskModifier;

public abstract class Actor {

	protected double experience; 		
	protected double stress;
	protected double frustration;
	protected double satisfaction;
	protected double motivation;
	protected boolean focus;		// should be activated explicitly
	protected boolean evilMode;   	// is activated when frustration exceeds value 8
	protected boolean alive;
	protected boolean working;
	protected TaskModifier taskModifier;
	protected List<String> phrases;
	
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

	// ######################################################################
	// # GETTERS OF CALCULATED FIELDS
	// ######################################################################
	
	public double getWorkAgility() {
		double auxExperience = experience;
		
		if (focus == false) {
			auxExperience *= 0.7;
		}
		
		return (double) auxExperience - (auxExperience * (stress / 10));
	}

	public byte getAge() {
		return (byte) ChronoUnit.YEARS
						.between(LocalDate.of(2000, 10, 7), LocalDate.now());
	}
	
	// ######################################################################
	// # PUBLIC METHODS
	// ######################################################################
	
	public void workOn(Task task) {
		if (!working) {
			working = true;
			Thread thread = new Thread(() -> {
				long initTime = System.currentTimeMillis(); // DEBUG
				
				while(task.getCompletedWork() < task.getWorkload()) {
					taskModifier.modifyCompletedWork(0.1, task);
					try {
						// DEBUG SNIPPET
						System.out.println(	" #!#!#!# task log -- workload " + task.getWorkload() + 
								" workCompleted " + task.getCompletedWork());
						
						// DEBUG SNIPPET END
						
						Thread.sleep(Math.round(Byte.MAX_VALUE - getWorkAgility()));
					} catch(InterruptedException ie) {
						System.out.println("Se interrumpió la ejecucíon de la tarea " +
											task.getName());
						working = false;
					}
				}
				
				long endTime = System.currentTimeMillis(); // DEBUG
				System.out.println("task done in " + (endTime - initTime) + " milliseconds"); // DEBUG
				
				task.setCompletedWork(task.getWorkload());
				try {
					processCompensation(taskModifier.submit(task));
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
	
	public void addPhrase(String phrase) {
		phrases.add(phrase);
	}
	
	public void addPhrases(List<String> phrases) {
		for (String phrase: phrases) {
			addPhrase(phrase);
		}
	}
	
	private void processCompensation(Map<String, Double> compensationPack) {
		experience += compensationPack.get("experience");
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
		return  getClass().getSimpleName() 					+ "[\n" +
					"\thashcode = " 	+ hashCode() 		+ ",\n" +
					"\texperience = " 	+ experience 		+ ",\n" +
					"\tstress = " 		+ stress 			+ ",\n" +
					"\tfrustration = " 	+ frustration 		+ ",\n" +
					"\tsatisfaction = " + satisfaction 		+ ",\n" +
					"\tmotivation = " 	+ motivation 		+ ",\n" +
					"\twork agility = "	+ getWorkAgility() 	+ ",\n" +
					"\tfocus = " 		+ focus 			+ ",\n" +
					"\tevilMode = " 	+ evilMode 			+ ",\n" +
					"\tworking = " 		+ working			+ ",\n" +
					"\talive = " 		+ alive 			+ "\n" +
				"]";
	}

}
