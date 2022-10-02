package eloy.model;

import java.time.LocalDate;

public abstract class Humano {

	protected float experience; 	// max 10'000
	protected float stress;	        // max 10'000
	protected float frustration;	// max 10'000
	protected float satisfaction;	// max 10'000
	protected float motivation;	    // max 10'000
	protected boolean focus;		// true by default
	protected boolean evilMode;     // true when 'frustration' exceed value 7
	protected boolean alive = true;

	
	public float getExperience() {
		return experience;
	}

	public float getStress() {
		return stress;
	}

	public float getFrustration() {
		return frustration;
	}

	public float getSatisfaction() {
		return satisfaction;
	}

	public float getMotivation() {
		return motivation;
	}

	public boolean isFocus() {
		return focus;
	}

	public boolean isEvilMode() {
		return evilMode;
	}

	public byte getAge() {
		byte age = 0;

		LocalDate bornDate = LocalDate.of(2000, 10, 7);

		age = (byte)java.time.temporal.ChronoUnit.YEARS.between(bornDate , LocalDate.now());

		return age;
	}

	public abstract void sayHi();
	
	public abstract void talk();
	
	
	
	
	


	// it's used to create a thread to check
	// the Human's mood on the basis of the
	// values of his properties
	protected class RunnableCheckMood implements Runnable {
		@Override
		public void run() {
			while(alive == true) {
				if (motivation < 0 && satisfaction < 0) {
					frustration += 0.4;
				}
				else if (motivation < 5 && satisfaction < 5) {
					frustration += 0.2;
				}
				else if (motivation >= 5 || satisfaction >= 5) {
					frustration -= 0.7;
				}

				if (motivation > 7 || satisfaction > 7) {
					frustration = 0;
				}


				if (frustration > 7) {
					evilMode = true;
					motivation -= 0.2;
					satisfaction -= 0.35;
				}
				else if (frustration >= 4 && frustration <= 7) {
					evilMode = true;
					motivation -= 0.1;
					satisfaction -= 0.2;
				}
				else if (frustration < 4 && frustration > 0) {
					evilMode = false;
					motivation -= 0.01;
					satisfaction -= 0.02; 
				}
				else if (frustration <= 0)
					evilMode = false;

				if (motivation > 10)
					motivation = 10;
				else if (motivation < 0)
					motivation = 0;
				if (satisfaction > 10)
					satisfaction = 10;
				else if (satisfaction < 0)
					satisfaction = 0;
				if (frustration > 10)
					frustration = 10;
				else if (frustration < 0)
					frustration = 0;

				try { Thread.sleep(1000); }
				catch (InterruptedException ie) {}
			}
		}
	}

}
