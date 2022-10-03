package com.ivan.eloy.eloysimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ivan.eloy.eloysimulator.core.model.Eloy;

public class Main {

	private static Map<Byte, String> options = new HashMap<>();
	
	public static void main(String[] args) {
		init();
		
		Eloy eloy = new Eloy();
		
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
					
				default: goAhead = false;
			}
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ie) {
				System.out.println(	"#########################################################\n" +
						"# The main thread was interrupted\n" +
						"#########################################################");
			}
			
			System.out.println("\n\n\n");
		}
		
		System.out.println("Nos vemos pronto.");
	}
	
	private static void init() {
		options.put((byte) 1, "saludar");
		options.put((byte) 2, "hablar");
		options.put((byte) 3, "informar de edad");
		options.put((byte) 4, "informar de estado");
	}
	
	private static byte requestOption() {
		System.out.println(	"#################################################################");
		
		List<Byte> codes = new ArrayList<>(options.keySet());
		Collections.sort(codes);
		
		for (Byte code : codes) {
			System.out.println(	"##	" + code + ". " + options.get(code) + "");
		}
		
		System.out.println(	"##	x. cualquier otra tecla para salir\n" +
							"#################################################################"
				);
		
		@SuppressWarnings("resource")
		String option = new Scanner(System.in).next();
		
		option = option.charAt(0) + "";
		
		return Byte.valueOf(option);
	}
}
