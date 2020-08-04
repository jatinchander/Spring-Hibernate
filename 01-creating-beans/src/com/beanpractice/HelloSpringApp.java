package com.beanpractice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve
		Coach baseballCoach = context.getBean("myCoach", Coach.class);
		
		// methods
		System.out.println(baseballCoach.getDailyWorkout());
		
		// close
		context.close();
	}

}
