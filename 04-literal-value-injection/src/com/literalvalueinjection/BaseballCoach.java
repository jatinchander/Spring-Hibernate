package com.literalvalueinjection;

public class BaseballCoach implements Coach {

	private FortuneService fortubeService;
	private String email;
	private String team;

	public BaseballCoach() {
		// TODO Auto-generated constructor stub
	}

	public FortuneService getFortubeService() {
		return fortubeService;
	}

	public void setFortubeService(FortuneService fortubeService) {
		this.fortubeService = fortubeService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "30 minutes of batting";
	}
	
	public String getFortune() {
		return fortubeService.getFortune();
	}

}
