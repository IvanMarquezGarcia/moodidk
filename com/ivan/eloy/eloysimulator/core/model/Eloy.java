package com.ivan.eloy.eloysimulator.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ivan.eloy.eloysimulator.core.utils.Constants;
import com.ivan.eloy.eloysimulator.mood.MoodModifierImpl;
import com.ivan.eloy.eloysimulator.mood.RunnableMoodManager;
import com.ivan.eloy.eloysimulator.tasks.management.TaskModifierImpl;

// Clase para instanciar un nuevo Eloy:

public class Eloy extends Human implements MariCarmen, ManuelJesus {

	List<String> phrases;
	
	public Eloy() {
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
		
		phrases = new ArrayList<>();
		addPhrases();
		
		taskModifier = new TaskModifierImpl();
		
		RunnableMoodManager rmc = new RunnableMoodManager(this, new MoodModifierImpl(this));
		
		Thread threadMoodController = new Thread(rmc);
		threadMoodController.start();
	}
	
	private void addPhrases() {
		phrases.add("Soy Eloy, tengo " + getAge() + " años, estoy mazado y quiero " +
				"aprenderlo todo.\nProgramación genérica ¡¿QUÉ?! Que te calle ya...");
		
		phrases.add("Illo, Farcon cállate un poquito padre.");
		
		phrases.add("La estoy liando parda, estoy haciendo un CHETO PADRE");
		
		phrases.add("*toca compulsivamente la mano de falcon* illo, illo, ayudame " +
				"un poquito hermano. el nota como es... farcon, farcon, farcon...");
		
		phrases.add("Illo, Iván ¿tú lo vas a hacer como lo pide? *cara de loco " +
				"delirando con hacerlo 100 veces mejor*");
		
		phrases.add("Te imagina que usamos Odoo?UUUUUNA POOOOLLAAA");
		
		phrases.add("*mira con cara de :)*");
	}
	
}
