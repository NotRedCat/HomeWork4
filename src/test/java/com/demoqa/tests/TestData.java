package com.demoqa.tests;

import com.github.javafaker.Faker;

import static java.lang.String.format;

public class TestData {
    Faker faker = new Faker();

    static String firstName = Faker.instance().name().firstName(),
            lastName = Faker.instance().name().lastName(),
            expectedFullName = format("%s %s", firstName, lastName),
            email = Faker.instance().internet().emailAddress(),
            gender = "Male",
            number = "7" + Faker.instance().number().digits(9),
            month = "April",
            day = Faker.instance().number().numberBetween(10, 30) + "",
            year = Faker.instance().number().numberBetween(1980, 2007) + "",
            subject = "Computer Science",
            hobby = "Music",
            file = "it-cat.jpg",
            address = Faker.instance().address().fullAddress(), state = "NCR", city = "Gurgaon";


}
