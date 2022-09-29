package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationFormTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    public void setRegistrationFormPage(RegistrationFormPage registrationFormPage) {

    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
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
                .checkResult("Student Name", expectedFullName)
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
