package eloy.model;

import java.time.LocalDate;
import java.util.Random;

import eloy.model.utils.Constants;
import eloy.mood.MoodModifierImpl;
import eloy.mood.RunnableMoodController;

// Clase para instanciar un nuevo Eloy:

public class Eloy extends God implements MariCarmen, Padre {

	private double experience; 		
	private double stress;
	private double frustration;
	private double satisfaction;
	private double motivation;
	private boolean focus;			// should be activated explicitly
	private boolean evilMode;   	// is activated when frustration exceeds value 8

	public Eloy() {
		motivation = Constants.MOTIVATION_MAX_VALUE;
		
		RunnableMoodController rmc = new RunnableMoodController(this, new MoodModifierImpl(this));
		
		Thread threadMoodController = new Thread(rmc);
		threadMoodController.start();
	}

	// ######################################################################
	// # GETTERS AND SETTERS
	// ######################################################################

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public double getStress() {
		return stress;
	}

	public void setStress(double stress) {
		this.stress = stress;
	}

	public double getFrustration() {
		return frustration;
	}

	public void setFrustration(double frustration) {
		this.frustration = frustration;
	}

	public double getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(double satisfaction) {
		this.satisfaction = satisfaction;
	}

	public double getMotivation() {
		return motivation;
	}

	public void setMotivation(double motivation) {
		this.motivation = motivation;
	}

	public boolean isFocus() {
		return focus;
	}

	public void setFocus(boolean focus) {
		this.focus = focus;
	}

	public boolean isEvilMode() {
		return evilMode;
	}

	public void setEvilMode(boolean evilMode) {
		this.evilMode = evilMode;
	}
	
	@Override
	public String toString() {
		return "Eloy [experience=" + experience + ", stress=" + stress + ", frustration=" +
				frustration + ", satisfaction=" + satisfaction + ", motivation=" + motivation +
				", focus=" + focus + ", evilMode=" + evilMode + "]";
	}
	
	// ######################################################################
	// # PUBLIC METHODS
	// ######################################################################

	public byte getAge() {
		byte edad = 0;
		
		LocalDate nac = LocalDate.of(2000, 10, 7);
		
		edad = (byte)java.time.temporal.ChronoUnit.YEARS.between(nac , LocalDate.now());
		
		return edad;
	}

	public void saludar() {
		System.out.println("Qué paja illo :)");
	}
	
	public void hablar() {
		Random r = new Random();
		int frase = r.nextInt(6);
		
		switch(frase) {
			case 0:
				System.out.println("Soy Eloy, tengo " + this.getAge() + " años, estoy mazado y " +
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

	// ######################################################################
	// # PRIVATE METHODS
	// ######################################################################

	
}