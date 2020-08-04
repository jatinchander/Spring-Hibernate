package com.literalvalueinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BaseballCoach baseballCoach = context.getBean("myCoach", BaseballCoach.class);
		
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getFortune());
		System.out.println(baseballCoach.getEmail());
		System.out.println(baseballCoach.getTeam());
		
		context.close();

	}

}
