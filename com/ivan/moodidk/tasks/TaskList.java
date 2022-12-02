package com.ivan.moodidk.tasks;

import java.util.ArrayList;
import java.util.List;

// TODO: implement and use

public class TaskList {

	private final List<Task> taskList;
	
	public TaskList() {
		taskList = new ArrayList<>();
	}
	
	public synchronized boolean addTask(Task task) {
		return false;
	}
	
	public boolean setTaskAsDone(int index) {
		
		return false;
	}
	
	public void showTaskList() {
		System.out.println(taskList);
	}
	
}
