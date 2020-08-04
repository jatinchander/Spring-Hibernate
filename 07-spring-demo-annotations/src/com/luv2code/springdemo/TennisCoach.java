package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Bean with ID
@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// Default Constructor
	public TennisCoach() {
		System.out.println("Default Constructor");
	}

	/*
	 * CONSTRUCTOR INJECTION
	 * 
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice!";
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	// SETTER INJECTION
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println("Inside setter"); this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
