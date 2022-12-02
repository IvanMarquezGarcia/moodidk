package com.ivan.eloy.eloysimulator.mood;


import com.ivan.eloy.eloysimulator.core.model.ActorImpl;
import com.ivan.eloy.eloysimulator.core.utils.Constants;

public class MoodModifierImpl implements MoodModifier {
	
	private ActorImpl eloy;
	
	public MoodModifierImpl(ActorImpl eloy) {
		this.eloy = eloy;
	}

	@Override
	public void modifyExperience(double modification) {
		double newExperience = eloy.getExperience() + modification;
		eloy.setExperience(newExperience);
	}

	@Override
	public void modifyStress(double modification) {
		double newStress = eloy.getStress() + modification;
		eloy.setStress(newStress);
	}

	@Override
	public void modifyFrustration(double modification) {
		double newFrustration = eloy.getFrustration() + modification;
		eloy.setFrustration(newFrustration);
	}

	@Override
	public void modifySatisfaction(double modification) {
		double newSatisfaction = eloy.getSatisfaction() + modification;
		eloy.setSatisfaction(newSatisfaction);
	}

	@Override
	public void modifyMotivation(double modification) {
		double newMotivation = eloy.getMotivation() + modification;
		eloy.setMotivation(newMotivation);
	}

	@Override
	public void modifyFocus(boolean modification) {
		eloy.setFocus(modification);
	}

	@Override
	public void modifyEvilMode(boolean modification) {
		eloy.setEvilMode(modification);
	}

	@Override
	public void fillStress() {
		eloy.setStress(Constants.STRESS_MAX_VALUE);
	}

	@Override
	public void fillFrustration() {
		eloy.setFrustration(Constants.FRUSTRATION_MAX_VALUE);
	}

	@Override
	public void fillSatisfaction() {
		eloy.setSatisfaction(Constants.SATISFACTION_MAX_VALUE);
	}

	@Override
	public void fillMotivation() {
		eloy.setMotivation(Constants.MOTIVATION_MAX_VALUE);
	}

	@Override
	public void clearStress() {
		eloy.setStress(0);
	}

	@Override
	public void clearFrustration() {
		eloy.setFrustration(0);
	}

	@Override
	public void clearSatisfaction() {
		eloy.setSatisfaction(0);
	}

	@Override
	public void clearMotivation() {
		eloy.setMotivation(0);
	}

}
