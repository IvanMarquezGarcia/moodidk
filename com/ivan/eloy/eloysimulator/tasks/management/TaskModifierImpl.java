package com.ivan.eloy.eloysimulator.tasks.management;

import com.ivan.eloy.eloysimulator.tasks.Dificulty;
import com.ivan.eloy.eloysimulator.tasks.Task;

public class TaskModifierImpl implements TaskModifier {

	@Override
	public void setDificulty(Dificulty dificulty, Task task) throws Exception {
		if (dificulty == null) {
			throw new NullPointerException("dificultad nula");
		}
		
		if (task.getDificulty() != null) {
			throw new IllegalStateException("la tarea " + task.getName() + " ya tiene una " +
											"asignada");
		}
		
		task.setDificulty(dificulty);
	}

	@Override
	public void setLimitDate(long limitDate, Task task) throws Exception {
		if (limitDate <= task.getInitDate()) {
			throw new IllegalArgumentException("la fecha limite debe ser posterior a la de inicio");
		}
		
		if (task.getLimitDate() != 0) {
			throw new IllegalStateException("la tarea " + task.getName() + " ya tiene fecha limite");
		}
		
		task.setLimitDate(limitDate);
	}

	@Override
	public void setWorkload(long workload, Task task) throws Exception {
		if (workload < 1) {
			throw new IllegalArgumentException("la carga de trabajo no puede ser inferior a 1");
		}
		
		if (task.getWorkload() != 0) {
			throw new IllegalStateException("la tarea " + task.getName() + " ya tiene asignada " +
											"una carga de trabajo");
		}
		
		task.setWorkload(workload);
	}
	
	@Override
	public void modifyCompletedWork(double modification, Task task) {
		task.setCompletedWork(task.getCompletedWork() + modification);
	}

	@Override
	public double submit(Task task) throws Exception {
		if (task.getDone()) {
			throw new IllegalStateException("tarea ya realizada");
		}
		
		if (task.getCompletedWork() < task.getWorkload()) {
			throw new IllegalStateException("tarea sin completar");
		}
		
		return task.getExperienceOnCompletion();
	}

	

}
