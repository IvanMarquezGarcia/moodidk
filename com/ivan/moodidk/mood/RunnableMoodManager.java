package com.ivan.moodidk.mood;

import com.ivan.moodidk.core.model.ActorImpl;

public class RunnableMoodManager implements Runnable {
	
	private ActorImpl actor;
	private MoodModifier moodModifier;
	
	public RunnableMoodManager(ActorImpl actor, MoodModifierImpl mmImpl) {
		this.actor = actor;
		this.moodModifier = mmImpl;
	}
	
	@Override
	public void run() {
		while(true) {
			if (actor.getMotivation() < 0 && actor.getSatisfaction() < 0) {
				moodModifier.modifyFrustration(0.4);
			}
			else if (actor.getMotivation() < 5 && actor.getSatisfaction() < 5) {
				moodModifier.modifyFrustration(0.2);
			}
			else if (actor.getMotivation() >= 5 || actor.getSatisfaction() >= 5) {
				moodModifier.modifyFrustration(-0.4);
			}
			
			if (actor.getMotivation() > 7 || actor.getSatisfaction() > 7) {
				moodModifier.clearFrustration();
			}
			
			if (actor.getFrustration() > 7) {
				moodModifier.modifyEvilMode(true);
				moodModifier.modifyMotivation(-0.2);
				moodModifier.modifySatisfaction(-0.35);
			}
			else if (actor.getFrustration() >= 4 && actor.getFrustration() <= 7) {
				moodModifier.modifyEvilMode(true);
				moodModifier.modifyMotivation(-0.1);
				moodModifier.modifySatisfaction(-0.2);
			}
			else if (actor.getFrustration() < 4 && actor.getFrustration() > 0) {
				moodModifier.modifyEvilMode(false);
				moodModifier.modifyMotivation(-0.01);
				moodModifier.modifySatisfaction(-0.02);
			}
			else if (actor.getFrustration() <= 0)
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
		if (actor.getMotivation() > 10)
			moodModifier.fillMotivation();
		else if (actor.getMotivation() < 0)
			moodModifier.clearMotivation();
		
		if (actor.getSatisfaction() > 10)
			moodModifier.fillSatisfaction();
		else if (actor.getSatisfaction() < 0)
			moodModifier.clearSatisfaction();
		
		if (actor.getFrustration() > 10)
			moodModifier.fillFrustration();
		else if (actor.getFrustration() < 0)
			moodModifier.clearFrustration();
		
		if (actor.getStress() > 10)
			moodModifier.fillStress();
		else if (actor.getStress() < 0)
			moodModifier.clearStress();
	}
}