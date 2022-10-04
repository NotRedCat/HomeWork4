package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.tests.properties.SystemPropertiesTest;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static java.lang.String.format;

public class TestBase {
    @Tag("properties")
    @BeforeAll
    static void configure() throws MalformedURLException {
      //  Configuration.baseUrl = "https://demoqa.com";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (System.getProperty("remote_url") != null) {
            Configuration.remote = System.getProperty("remote_url");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

        }

        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        Configuration.browserCapabilities = capabilities;
        System.out.println(Configuration.browser);
        System.out.println(Configuration.browserVersion);
        System.out.println(Configuration.browserSize);

    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
