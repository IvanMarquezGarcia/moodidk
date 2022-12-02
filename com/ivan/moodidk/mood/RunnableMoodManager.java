package com.ivan.moodidk.mood;

import com.ivan.moodidk.core.model.ActorImpl;

public class RunnableMoodManager implements Runnable {
	
	private ActorImpl eloy;
	private MoodModifier moodModifier;
	
	public RunnableMoodManager(ActorImpl eloy, MoodModifierImpl mmImpl) {
		this.eloy = eloy;
		this.moodModifier = mmImpl;
	}
	
	@Override
	public void run() {
		while(true) {
			if (eloy.getMotivation() < 0 && eloy.getSatisfaction() < 0) {
				moodModifier.modifyFrustration(0.4);
			}
			else if (eloy.getMotivation() < 5 && eloy.getSatisfaction() < 5) {
				moodModifier.modifyFrustration(0.2);
			}
			else if (eloy.getMotivation() >= 5 || eloy.getSatisfaction() >= 5) {
				moodModifier.modifyFrustration(-0.4);
			}
			
			if (eloy.getMotivation() > 7 || eloy.getSatisfaction() > 7) {
				moodModifier.clearFrustration();
			}
			
			if (eloy.getFrustration() > 7) {
				moodModifier.modifyEvilMode(true);
				moodModifier.modifyMotivation(-0.2);
				moodModifier.modifySatisfaction(-0.35);
			}
			else if (eloy.getFrustration() >= 4 && eloy.getFrustration() <= 7) {
				moodModifier.modifyEvilMode(true);
				moodModifier.modifyMotivation(-0.1);
				moodModifier.modifySatisfaction(-0.2);
			}
			else if (eloy.getFrustration() < 4 && eloy.getFrustration() > 0) {
				moodModifier.modifyEvilMode(false);
				moodModifier.modifyMotivation(-0.01);
				moodModifier.modifySatisfaction(-0.02);
			}
			else if (eloy.getFrustration() <= 0)
				moodModifier.modifyEvilMode(false);
			
			adjustLimits();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				System.out.println(	"#########################################################\n" +
									"# The runnable method of thread mood checker was interrupted\n" +
									"#########################################################");
			}
		}
	}
	
	private void adjustLimits() {
		if (eloy.getMotivation() > 10)
			moodModifier.fillMotivation();
		else if (eloy.getMotivation() < 0)
			moodModifier.clearMotivation();
		
		if (eloy.getSatisfaction() > 10)
			moodModifier.fillSatisfaction();
		else if (eloy.getSatisfaction() < 0)
			moodModifier.clearSatisfaction();
		
		if (eloy.getFrustration() > 10)
			moodModifier.fillFrustration();
		else if (eloy.getFrustration() < 0)
			moodModifier.clearFrustration();
		
		if (eloy.getStress() > 10)
			moodModifier.fillStress();
		else if (eloy.getStress() < 0)
			moodModifier.clearStress();
	}
}