package com.demoqa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleTest {

    @BeforeAll
    static void configure(){
       System.out.println("this is the @BeforeAll");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("this is the @AfterAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("this is the @BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("this is the @AfterEach");
    }

    @Test
    void firstTest0(){
        System.out.println("this is the @Test 0");
    }

    @Test
    void firstTest1(){
        System.out.println("this is the @Test 1");
    }


}
