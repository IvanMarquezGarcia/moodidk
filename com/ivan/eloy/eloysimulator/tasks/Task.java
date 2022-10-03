package com.ivan.eloy.eloysimulator.tasks;

public class Task {

	private String name;
	private Dificulty dificulty;
	private String limitDate;
	private double workload; // simulated with a thread counting up to the value in 0.1 steps of 0.1
	private boolean done;
	
	public Task() {}

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

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public double getWorkload() {
		return workload;
	}

	public void setWorkload(double workload) {
		this.workload = workload;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

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
