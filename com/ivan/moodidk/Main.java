package com.ivan.moodidk;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ivan.moodidk.core.model.ActorImpl;
import com.ivan.moodidk.core.utils.Date;
import com.ivan.moodidk.tasks.Dificulty;
import com.ivan.moodidk.tasks.Task;

public class Main {

	private static Map<Byte, String> menuOptions = new HashMap<>();
	
	public static void main(String[] args) {
		
		init();
		
		ActorImpl eloy = new ActorImpl();
		
		byte optionCode = -1;
		boolean goAhead = true;
		
		while (goAhead) {
			optionCode = requestOption();
			
			switch(optionCode) {
				case 1: eloy.sayHi();
					break;
				
				case 2: eloy.talk();
					break;
				
				case 3: System.out.println(eloy.getAge());
					break;
				
				case 4: System.out.println(eloy.toString());
					break;
					
				case 5:
					Task task = new Task();
					task.setName("testTask");
					try {
						eloy.getTaskModifier().setDificulty(Dificulty.EASY, task);
						eloy.getTaskModifier().setWorkload(5, task);
						eloy.getTaskModifier().setLimitDate(
								Date.LocalDateTimeToMillis(LocalDateTime.now()) + 5, task);
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					
					System.out.println("DEBUG - " + task);
					
					eloy.workOn(task);
					
					break;
					
				default: goAhead = false;
			}
			
			System.out.println("\nany key to show the menu...");
			new Scanner(System.in).next();
			
			System.out.println("\n\n\n");
		}
		
		System.out.println("Nos vemos pronto.");
	}
	
	private static void init() {
		menuOptions.put((byte) 1, "saludar");
		menuOptions.put((byte) 2, "hablar");
		menuOptions.put((byte) 3, "informar de edad");
		menuOptions.put((byte) 4, "informar de estado");
		menuOptions.put((byte) 5, "tarea");
	}
	
	private static byte requestOption() {
		System.out.println(	"#################################################################");
		
		List<Byte> codes = new ArrayList<>(menuOptions.keySet());
		Collections.sort(codes);
		
		for (Byte code : codes) {
			System.out.println(	"##	" + code + ". " + menuOptions.get(code) + "");
		}
		
		System.out.println(	"##	x. cualquier otra tecla para salir\n" +
							"#################################################################"
				);
		
		@SuppressWarnings("resource")
		String option = new Scanner(System.in).next();
		
		while(!Character.isDigit(option.charAt(0))) {
			option = option.charAt(0) + "";
		}
		
		return Byte.valueOf(option);
	}
}
