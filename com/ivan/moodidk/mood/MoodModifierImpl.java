package com.ivan.moodidk.mood;

import com.ivan.moodidk.core.model.ActorImpl;
import com.ivan.moodidk.core.utils.Constants;

public class MoodModifierImpl implements MoodModifier {
	
	private ActorImpl actor;
	
	public MoodModifierImpl(ActorImpl actor) {
		this.actor = actor;
	}

	@Override
	public void modifyExperience(double modification) {
		double newExperience = actor.getExperience() + modification;
		actor.setExperience(newExperience);
	}

	@Override
	public void modifyStress(double modification) {
		double newStress = actor.getStress() + modification;
		actor.setStress(newStress);
	}

	@Override
	public void modifyFrustration(double modification) {
		double newFrustration = actor.getFrustration() + modification;
		actor.setFrustration(newFrustration);
	}

	@Override
	public void modifySatisfaction(double modification) {
		double newSatisfaction = actor.getSatisfaction() + modification;
		actor.setSatisfaction(newSatisfaction);
	}

	@Override
	public void modifyMotivation(double modification) {
		double newMotivation = actor.getMotivation() + modification;
		actor.setMotivation(newMotivation);
	}

	@Override
	public void modifyFocus(boolean modification) {
		actor.setFocus(modification);
	}

	@Override
	public void modifyEvilMode(boolean modification) {
		actor.setEvilMode(modification);
	}

	@Override
	public void fillStress() {
		actor.setStress(Constants.STRESS_MAX_VALUE);
	}

	@Override
	public void fillFrustration() {
		actor.setFrustration(Constants.FRUSTRATION_MAX_VALUE);
	}

	@Override
	public void fillSatisfaction() {
		actor.setSatisfaction(Constants.SATISFACTION_MAX_VALUE);
	}

	@Override
	public void fillMotivation() {
		actor.setMotivation(Constants.MOTIVATION_MAX_VALUE);
	}

	@Override
	public void clearStress() {
		actor.setStress(0);
	}

	@Override
	public void clearFrustration() {
		actor.setFrustration(0);
	}

	@Override
	public void clearSatisfaction() {
		actor.setSatisfaction(0);
	}

	@Override
	public void clearMotivation() {
		actor.setMotivation(0);
	}

}
