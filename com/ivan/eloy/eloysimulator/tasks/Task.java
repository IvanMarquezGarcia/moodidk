package com.ivan.eloy.eloysimulator.tasks;

import java.time.LocalDateTime;

import com.ivan.eloy.eloysimulator.core.utils.Date;

public class Task {

	private String name;
	private Dificulty dificulty;
	private long initDate;
	private long limitDate;
	private long workload; // simulated with a thread counting up to the value in 0.1 steps of 0.1
	private double completedWork;
	private boolean done;
	
	public Task() {
		initDate = Date.LocalDateTimeToMillis(LocalDateTime.now());
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
	
	public double getCompletedWork() {
		return completedWork;
	}

	public void setCompletedWork(double completedWork) {
		this.completedWork = completedWork;
	}
	
	public boolean getDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	// ######################################################################
	// # PUBLIC METHODS
	// ######################################################################
	
	public double getIntensity() {
		// TODO: refactor
		long availableTime = limitDate - initDate;
		double r = (double) workload / availableTime;
		return r;
	}
	
	public double getRelativeIntensity() {
		// TODO: test
		long availableTime = limitDate - Date.LocalDateTimeToMillis(LocalDateTime.now());
		double r = (double) (workload - completedWork) / availableTime;
		return r;
	}
	
	public double getExperienceOnCompletion() {
		// TODO: refactor
		double intensity = getIntensity();
		int difi = dificulty.ordinal() + 1;
		return intensity * difi;
	}
	
	// ######################################################################
	// # INHERETED METHODS IMPLEMENTED
	// ######################################################################

	@Override
	public String toString() {
		return "Task [\n" +
					"\thashcode = "  	   + hashCode() 	+ ",\n" +
					"\tname = " 	 	   + name 			+ ",\n" +
					"\tdificulty = " 	   + dificulty 		+ ",\n" +
					"\tinitDate = "  	   + initDate 		+ ",\n" +
					"\tlimitDate = " 	   + limitDate 		+ ",\n" +
					"\tworkload = "  	   + workload 		+ ",\n" +
					"\tcompleted work = "  + completedWork 	+ "\n" +
					"\tdone = "  		   + done 			+ "\n" +
				"]";
	}
	
}
