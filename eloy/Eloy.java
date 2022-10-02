package eloy;

import java.time.LocalDate;
import java.util.Random;

/*
	Has sido un gran descubrimiento en mi vida.
	Espero que esto sea el inicio de una larga amistad.
	En cualquier caso, sigue como hasta ahora, vas a llegar lejos.

	Clase para instanciar un nuevo Eloy:
 */

public class Eloy extends God implements MariCarmen, Padre {

	private float experiencia; 	// max 10'000
	private float estres;		// max 10'000
	private float frustracion;	// max 10'000
	private float satisfaccion;	// max 10'000
	private float motivacion;	// max 10'000
	private boolean focus;		// true por defecto
	private boolean cabronMode; // se activa cuando la frustración sobrepasa el valor 7
	
	// usado para crear un hilo que compruebe
	// el estado de ánimo del eloy en base a
	// sus propiedades.
	private class RunnableEstado implements Runnable {
		@Override
		public void run() {
			while('E' == 'E') {
				if (motivacion < 0 && satisfaccion < 0) {
					frustracion += 0.4;
				}
				else if (motivacion < 5 && satisfaccion < 5) {
					frustracion += 0.2;
				}
				else if (motivacion >= 5 || satisfaccion >= 5) {
					frustracion -= 0.7;
				}
				
				if (motivacion > 7 || satisfaccion > 7) {
					frustracion = 0;
				}
				
				
				if (frustracion > 7) {
					cabronMode = true;
					motivacion -= 0.2;
					satisfaccion -= 0.35;
				}
				else if (frustracion >= 4 && frustracion <= 7) {
					cabronMode = true;
					motivacion -= 0.1;
					satisfaccion -= 0.2;
				}
				else if (frustracion < 4 && frustracion > 0) {
					cabronMode = false;
					motivacion -= 0.01;
					satisfaccion -= 0.02; 
				}
				else if (frustracion <= 0)
					cabronMode = false;
				
				if (motivacion > 10)
					motivacion = 10;
				else if (motivacion < 0)
					motivacion = 0;
				if (satisfaccion > 10)
					satisfaccion = 10;
				else if (satisfaccion < 0)
					satisfaccion = 0;
				if (frustracion > 10)
					frustracion = 10;
				else if (frustracion < 0)
					frustracion = 0;
				
				try { Thread.sleep(1000); }
				catch (InterruptedException ie) {}
			}
		}
	}


	//----------------------------------------------------------------------------------------------------------------------------------------


	public Eloy() {
		this(true, false);
	}

	public Eloy(boolean focus, boolean cabronMode) {
		this((float) 0, (float) 0, (float) 0, (float) 0, (float) 10, focus, cabronMode);
	}

	public Eloy(float experiencia, float estres, float frustracion, float satisfaccion, float motivacion, boolean focus, boolean cabronMode) {
		this.experiencia = experiencia;
		this.estres = estres;
		this.frustracion = frustracion;
		this.satisfaccion = satisfaccion;
		this.motivacion = motivacion;
		this.focus = focus;
		this.cabronMode = cabronMode;
		
		RunnableEstado re = new RunnableEstado();
		Thread comprobadorEstado = new Thread(re);
		comprobadorEstado.start();
	}


	//----------------------------------------------------------------------------------------------------------------------------------------


	public float getExperiencia() {
		return experiencia;
	}

	public float getEstres() {
		return estres;
	}

	public float getFrustracion() {
		return frustracion;
	}

	public float getSatisfaccion() {
		return satisfaccion;
	}

	public float getMotivacion() {
		return motivacion;
	}

	public boolean isFocus() {
		return focus;
	}

	public boolean isCabronMode() {
		return cabronMode;
	}
	
	public byte getEdad() {
		byte edad = 0;
		
		LocalDate nac = LocalDate.of(2000, 10, 7);
		
		edad = (byte)java.time.temporal.ChronoUnit.YEARS.between(nac , LocalDate.now());
		
		return edad;
	}
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------

	
	public void saludar() {
		System.out.println("Qué paja illo :)");
	}
	
	public void hablar() {
		Random r = new Random();
		int frase = r.nextInt(6);
		
		switch(frase) {
			case 0:
				System.out.println("Soy Eloy, tengo " + this.getEdad() + " años, estoy mazado y quiero aprenderlo todo.\nProgramación genérica ¡¿QUÉ?! Que te calle ya...");
				break;
			
			case 1:
				System.out.println("Illo, Farcon cállate un poquito padre.");
				break;
				
			case 2:
				System.out.println("La estoy liando parda, estoy haciendo un CHETO PADRE");
				break;
				
			case 3:
				System.out.println("*toca compulsivamente la mano de falcon* illo, illo, ayudame un poquito hermano. el nota como es... farcon, farcon, farcon...");
				break;
				
			case 4:
				System.out.println("Illo, Iván ¿tú lo vas a hacer como lo pide? *cara de loco delirando con hacerlo 100 veces mejor*");
				break;
				
			case 5:
				System.out.println("Te imagina que usamos Odoo?UUUUUNA POOOOLLAAA");
				break;
				
			default:
				saludar();
		}
	}
	
}