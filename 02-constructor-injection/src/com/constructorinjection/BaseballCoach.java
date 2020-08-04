package com.constructorinjection;

public class BaseballCoach implements Coach {
	
	// Interface
	private FortuneService fortuneService;
	
	// Default Constructor
	public BaseballCoach() {
		
	}
	
	// Constructor Injection (happyfortune obj will made behind the scenes)
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "30 minutes of batting";
	}
	
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}
