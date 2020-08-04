package com.dependencyinjectionpractice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BaseballCoach baseballCoach = context.getBean("baseballCoach", BaseballCoach.class);
		
		System.out.println(baseballCoach.getDailyworkout());
		System.out.println(baseballCoach.getFortune());

	}

}
