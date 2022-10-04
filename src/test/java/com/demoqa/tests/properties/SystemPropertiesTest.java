package com.demoqa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    String browserName,
            browserVersion,
            browserSize;

    @Test
    @Tag("properties")
    void simplePropertyTest1() {
        browserName = System.getProperty("browser_name", "firefox");
        browserVersion = System.getProperty("browser_version", "101");
        browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

}
