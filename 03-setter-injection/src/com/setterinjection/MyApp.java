package com.setterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		Coach baseballCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getFortune());
		
		context.close();
	
	}

}
