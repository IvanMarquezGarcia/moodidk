package com.ivan.eloy.eloysimulator.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

	private final List<Task> taskList;
	
	public TaskList() {
		taskList = new ArrayList<>(0);
	}
	
	public synchronized boolean addTask(Task task) {
		return taskList.add(task);
	}
	
	public boolean setTaskAsDone(int index) {
		Task task = taskList.get(index);
		
		// TODO: check if task is really finished
		if (task != null) {
			task.setDone(true);
		}
		
		return false;
	}
	
	public void showTaskList() {
		System.out.println(taskList);
	}
	
}
