package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1800x1200";

    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Ivanov@mail.ru")
                .setGender("Male")
                .setUserNumber("8924512475")
                .setBirtDate("27", "April", "1995")
                .setSubject("Computer Science")
                .setHobby("Music")
                .uploadFile("it-cat.jpg")
                .setAddress("some address 1")
                .setValuesStateAndCity("NCR", "Gurgaon")
                .clickSubmit()
                .checkResultsModalVisible()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Ivanov@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8924512475")
                .checkResult("Date of Birth", "27 April,1995")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "it-cat.jpg")
                .checkResult("Address", "some address 1")
                .checkResult("State and City", "NCR Gurgaon");

    }
}
