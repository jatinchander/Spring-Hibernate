package com.dependencyinjectionpractice;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	public BaseballCoach() {

	}

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		return "30 minutes of batting";
	}

	public String getFortune() {
		return fortuneService.getFortune();
	}

}
