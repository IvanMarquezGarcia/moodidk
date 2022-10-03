package com.ivan.eloy.eloysimulator.core.model;

import java.util.Random;

import com.ivan.eloy.eloysimulator.core.utils.Constants;
import com.ivan.eloy.eloysimulator.mood.MoodModifierImpl;
import com.ivan.eloy.eloysimulator.mood.RunnableMoodManager;
import com.ivan.eloy.eloysimulator.tasks.TaskList;

// Clase para instanciar un nuevo Eloy:

public class Eloy extends Human implements MariCarmen, Padre {

	public TaskList taskList;
	
	public Eloy() {
		motivation = Constants.MOTIVATION_MAX_VALUE;
		
		taskList = new TaskList();
		
		RunnableMoodManager rmc = new RunnableMoodManager(this, new MoodModifierImpl(this));
		
		Thread threadMoodController = new Thread(rmc);
		threadMoodController.start();
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
		int frase = r.nextInt(6);
		
		switch(frase) {
			case 0:
				System.out.println("Soy Eloy, tengo " + getAge() + " años, estoy mazado y " +
						"quiero aprenderlo todo.\nProgramación genérica ¡¿QUÉ?! Que te calle ya...");
				break;
			
			case 1:
				System.out.println("Illo, Farcon cállate un poquito padre.");
				break;
				
			case 2:
				System.out.println("La estoy liando parda, estoy haciendo un CHETO PADRE");
				break;
				
			case 3:
				System.out.println("*toca compulsivamente la mano de falcon* illo, illo, ayudame " +
						"un poquito hermano. el nota como es... farcon, farcon, farcon...");
				break;
				
			case 4:
				System.out.println("Illo, Iván ¿tú lo vas a hacer como lo pide? *cara de loco " +
						"delirando con hacerlo 100 veces mejor*");
				break;
				
			case 5:
				System.out.println("Te imagina que usamos Odoo?UUUUUNA POOOOLLAAA");
				break;
				
			default:
				System.out.println("*mira con cara de :)*");
		}
	}
	
}
