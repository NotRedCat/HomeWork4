package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.ru");
        $("[for = gender-radio-1]").click();
        $("#userNumber").setValue("89245124758");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/it-cat.jpg"));
        $("#currentAddress").setValue("some address 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                text("Ivan Ivanov"),
                text("Ivanov@mail.ru"),
                text("Male"),
                text("8924512475"),
                text("27 April,1995"),
                text("Computer Science"),
                text("Music"),
                text("it-cat.jpg"),
                text("some address 1"),
                text("NCR Gurgaon"));
    }
}


