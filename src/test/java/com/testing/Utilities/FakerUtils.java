package com.testing.Utilities;

import com.github.javafaker.Faker;

public class FakerUtils {

	public long randomNumber()
	{
		Faker faker = new Faker();
		return faker.number().randomNumber();
	}
}
