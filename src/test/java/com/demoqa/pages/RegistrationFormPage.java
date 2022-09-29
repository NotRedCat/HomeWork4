package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModalComponent;
import com.demoqa.pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    //Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumber = $("#userNumber");

    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirtDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        ;
        return this;
    }

    public RegistrationFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage checkResultsModalVisible() {
        resultsModalComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage setValuesStateAndCity(String state, String city) {
        stateAndCityComponent.setStateAndSity(state, city);
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModalComponent.checkResult(key, value);
        return this;
    }
}
