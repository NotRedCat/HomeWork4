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
        browserName = System.getProperty("browser_name");
        browserVersion = System.getProperty("browser_version");
        browserSize = System.getProperty("browser_size");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

}
