package com.ivan.eloy.eloysimulator.core.model;

import java.time.LocalDate;

import com.ivan.eloy.eloysimulator.tasks.Task;

public abstract class Human {

	protected double experience; 		
	protected double stress;
	protected double frustration;
	protected double satisfaction;
	protected double motivation;
	protected boolean focus;		// should be activated explicitly
	protected boolean evilMode;   	// is activated when frustration exceeds value 8
	protected boolean alive;
	
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
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
		// TODO
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
		return  getClass().getSimpleName() + "[\n" +
					"\thashcode = " + hashCode() + "\n" +
					"\texperience = " + experience + ",\n" +
					"\tstress = " + stress + ",\n" +
					"\tfrustration = " + frustration + ",\n" +
					"\tsatisfaction = " + satisfaction + ",\n" +
					"\tmotivation = " + motivation + ",\n" +
					"\tfocus = " + focus + ",\n" +
					"\tevilMode = " + evilMode + "\n" +
				"]";
	}

}
