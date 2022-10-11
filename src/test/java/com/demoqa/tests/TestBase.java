package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void configure() throws MalformedURLException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com/";
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));



        /*capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "100.0");
        Configuration.browserSize = "1800x1200";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";*/



        if (System.getProperty("remote_url") != null){
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "100.0");
            Configuration.browserSize = "1800x1200";
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

            /*
            capabilities.setCapability("browserName", System.getProperty("browser_name"));
            capabilities.setCapability("browserVersion", System.getProperty("browser_version"));
            //Configuration.browser = System.getProperty("browser_name");
            //Configuration.browserVersion = System.getProperty("browser_version");
            Configuration.browserSize = System.getProperty("browser_size");
            Configuration.remote = System.getProperty("remote_url");*/
        } else {
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "100.0");
            Configuration.browserSize = "1800x1200";
            Configuration.browser = "chrome";
        }
    }


    @AfterEach
    void addAttachments(){
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
