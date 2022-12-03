package com.ivan.moodidk.core.model;

import java.util.Random;

import com.ivan.moodidk.core.utils.Constants;
import com.ivan.moodidk.mood.MoodModifierImpl;
import com.ivan.moodidk.mood.RunnableMoodManager;
import com.ivan.moodidk.tasks.management.TaskModifierImpl;

public class ActorImpl extends Actor {
	
	public ActorImpl() {
		init();
	}
	
	// ######################################################################
	// # INHERITED METHODS IMPLEMENTED
	// ######################################################################

	@Override
	public void sayHi() {
		System.out.println("Qué paja illo :)");
	}
	
	@Override
	public void talk() {
		Random r = new Random();
		int phrase = r.nextInt(phrases.size());
		
		System.out.println(phrases.get(phrase));
	}
	
	// ######################################################################
	// # PRIVATE METHODS
	// ######################################################################
	
	private void init() {
		motivation = Constants.MOTIVATION_MAX_VALUE;
		
		taskModifier = new TaskModifierImpl();
		
		RunnableMoodManager rmc = new RunnableMoodManager(this, new MoodModifierImpl(this));
		
		Thread threadMoodManager = new Thread(rmc);
		threadMoodManager.start();
	}
	
}
