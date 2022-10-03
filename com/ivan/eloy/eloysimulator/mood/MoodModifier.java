package com.ivan.eloy.eloysimulator.mood;

public interface MoodModifier {

	void modifyExperience(double modification);
	
	void modifyStress(double modification);
	
	void modifyFrustration(double modification);
	
	void modifySatisfaction(double modification);
	
	void modifyMotivation(double modification);
	
	void modifyFocus(boolean modification);
	
	void modifyEvilMode(boolean modification);
	
	void fillStress();
	
	void fillFrustration();
	
	void fillSatisfaction();
	
	void fillMotivation();
	
	void clearStress();
	
	void clearFrustration();
	
	void clearSatisfaction();
	
	void clearMotivation();
	
}
