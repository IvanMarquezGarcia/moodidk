package com.ivan.eloy.eloysimulator.tasks;

import java.time.LocalDateTime;

import com.ivan.eloy.eloysimulator.core.utils.Date;

public class Task {

	private String name;
	private Dificulty dificulty;
	private long initDate;
	private long limitDate;
	private long workload; // simulated with a thread counting up to the value in 0.1 steps of 0.1
	private boolean done;
	
	public Task() {
		initDate = Date.LocalDateTimeMillis(LocalDateTime.now());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dificulty getDificulty() {
		return dificulty;
	}

	public void setDificulty(Dificulty dificulty) {
		this.dificulty = dificulty;
	}

	public long getInitDate() {
		return initDate;
	}

	public long getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(long limitDate) {
		this.limitDate = limitDate;
	}

	public long getWorkload() {
		return workload;
	}

	public void setWorkload(long workload) {
		this.workload = workload;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	// ######################################################################
	// # PUBLIC METHODS
	// ######################################################################
	
	public double getIntensity() {
		long availableTime = limitDate - initDate;
		return workload / availableTime;
	}
	
	public double getExperienceOnCompletion() {
		return getIntensity() * dificulty.ordinal();
	}
	
	// ######################################################################
	// # INHERETED METHODS IMPLEMENTED
	// ######################################################################

	@Override
	public String toString() {
		return "Task [\n" +
					"\thashcode = " + hashCode() +
					"\tname = " + name + ",\n" +
					"\tdificulty = " + dificulty + ",\n" +
					"\tlimitDate = " + limitDate + ",\n" +
					"\tworkload = " + workload + ",\n" +
					"\tdone=" + done +
				"]";
	}
	
}
