package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.tests.properties.SystemPropertiesTest;
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
        String browserName = System.getProperty("browser_name", "firefox");
        String browserVersion = System.getProperty("browser_version", "100.0");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
      /*      Configuration.remote = System.getProperty("remote_url");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        } else {
            Configuration.browserCapabilities = capabilities;
            Configuration.baseUrl = "https://demoqa.com/";
            Configuration.browser = System.getProperty("browser_name", "chrome");
            Configuration.browserVersion = System.getProperty("browser_version", "100.0");
            Configuration.browserSize = "1800x1200";
        }*/
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
