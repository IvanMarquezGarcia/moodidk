package com.ivan.moodidk.tasks.management;

import java.util.HashMap;
import java.util.Map;

import com.ivan.moodidk.tasks.Dificulty;
import com.ivan.moodidk.tasks.Task;

public class TaskModifierImpl implements TaskModifier {

	@Override
	public void setDificulty(Dificulty dificulty, Task task) throws Exception {
		if (dificulty == null) {
			throw new NullPointerException("null difficulty");
		}
		
		if (task.getDificulty() != null) {
			throw new IllegalStateException("the task " + task.getName() +
					" has already a difficulty assigned");
		}
		
		task.setDificulty(dificulty);
	}

	@Override
	public void setLimitDate(long limitDate, Task task) throws Exception {
		if (limitDate <= task.getInitDate()) {
			throw new IllegalArgumentException("the limit date should be "
					+ "greater than start date");
		}
		
		if (task.getLimitDate() != 0) {
			throw new IllegalStateException("the task " + task.getName() +
					" has already a limit date assigned");
		}
		
		task.setLimitDate(limitDate);
	}

	@Override
	public void setWorkload(long workload, Task task) throws Exception {
		if (workload < 1) {
			throw new IllegalArgumentException("the workload cannot be "
					+ "less than 1");
		}
		
		if (task.getWorkload() != 0) {
			throw new IllegalStateException("the task " + task.getName() +
					" has already assigned a workload una carga de trabajo");
		}
		
		task.setWorkload(workload);
	}
	
	@Override
	public void modifyCompletedWork(double modification, Task task) {
		task.setCompletedWork(task.getCompletedWork() + modification);
	}

	@Override
	public Map<String, Double> submit(Task task) throws Exception {
		if (task.getDone()) {
			throw new IllegalStateException("the task was already done");
		}
		
		if (task.getCompletedWork() < task.getWorkload()) {
			throw new IllegalStateException("incompleted task");
		}
		
		Map<String, Double> compensationPack = new HashMap<>();
		
		compensationPack.put("experience", task.getExperienceOnCompletion());
		
		return compensationPack;
	}

}
