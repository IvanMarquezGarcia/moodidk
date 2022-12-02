package com.ivan.moodidk.tasks.management;

import java.util.Map;

import com.ivan.moodidk.tasks.Dificulty;
import com.ivan.moodidk.tasks.Task;

public interface TaskModifier {
	
	void setDificulty(Dificulty dificulty, Task task) throws Exception;

	void setLimitDate(long limitDate, Task task) throws Exception;

	void setWorkload(long workload, Task task) throws Exception;
	
	Map<String, Double> submit(Task task) throws Exception;
	
	void modifyCompletedWork(double modification, Task task);
	
}
