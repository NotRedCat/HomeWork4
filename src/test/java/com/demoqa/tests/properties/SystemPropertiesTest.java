package com.demoqa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SystemPropertiesTest {
    String browserName,
            browserVersion,
            browserSize;

    @Test
    @Tag("properties_test")

    void simplePropertyTest1() {
        step("Open registration form", () ->
        {browserName = System.getProperty("browser_name", "firefox");
        browserVersion = System.getProperty("browser_version", "101");
        browserSize = System.getProperty("browser_size", "1920x1080");});
        step("Open registration form", () ->
        {System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);});
    }

}
