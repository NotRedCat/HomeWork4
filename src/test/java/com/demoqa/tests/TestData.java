package com.demoqa.tests;

import com.github.javafaker.Faker;

import static java.lang.String.format;
public class TestData {
   Faker faker = new Faker();
   static String firstName = Faker.instance().name().firstName(),
            lastName = "Ivanov",
            expectedFullName = format("%s %s", firstName, lastName);

}
