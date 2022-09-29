package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

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
                .setGender("Famale")
                .setUserNumber("89245124758")
                .setBirtDate("27", "April", "1995");

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("it-cat.jpg");
        $("#currentAddress").setValue("some address 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-dialog").shouldHave(appear);
        $(".table-responsive").shouldHave(
                text("Ivan Ivanov"),
                text("Ivanov@mail.ru"),
                text("Male"),
                text("27 April,1995"),
                text("8924512475"),
                text("Computer Science"),
                text("Music"),
                text("it-cat.jpg"),
                text("some address 1"),
                text("NCR Gurgaon"));
    }
}
