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
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setBirtDate(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadFile(file)
                .setAddress(address)
                .setValuesStateAndCity(state, city)
                .clickSubmit()
                .checkResultsModalVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", format(("%s %s,%s"), day, month, year))
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", file)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }
}
