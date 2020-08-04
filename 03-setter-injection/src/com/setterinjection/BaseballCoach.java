package com.setterinjection;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
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
