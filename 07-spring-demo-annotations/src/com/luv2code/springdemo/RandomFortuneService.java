package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings
	private String[] data = {"Nice", "Cool", "Wow"};
	
	// random number
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick random string from array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
