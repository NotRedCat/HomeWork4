package com.demoqa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    String browserName,
            browserVersion,
            browserSize;

    @Test
    @Tag("properties")
    void simplePropertyTes1() {
        browserName = System.getProperty("browser_name", "firefox");
        browserVersion = System.getProperty("browser_version", "101");
        browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

    @Test
    @Tag("properties")
    void simplePropertyTes2() {
        browserName = System.getProperty("browser_name", "chrome");
        browserVersion = System.getProperty("browser_version", "100");
        browserSize = System.getProperty("browser_size", "1600x900");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

    @Test
    @Tag("properties")
    void simplePropertyTes3() {
        browserName = System.getProperty("browser_name", "firefox");
        browserVersion = System.getProperty("browser_version", "100");
        browserSize = System.getProperty("browser_size", "600x600");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

    @Test
    @Tag("hello")
    void simplePropertyTes5() {
        System.out.println("Hello, " + System.getProperty("some_text", "qa.guru"));
    }
}