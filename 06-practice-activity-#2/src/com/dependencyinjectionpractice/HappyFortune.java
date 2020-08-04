package com.dependencyinjectionpractice;

public class HappyFortune implements FortuneService {
	
	String [] array = {"Yes", "Cool", "Nice"};

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
		// return a random number between 0-2
		int random = (int)(Math.random()*(3));
		
		String s = array[random];
		
		return s;
	}

}
