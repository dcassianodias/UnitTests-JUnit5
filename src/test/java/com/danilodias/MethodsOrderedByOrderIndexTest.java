package com.danilodias;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndexTest {

    StringBuilder completed = new StringBuilder("");

    @AfterEach
    void afterEach(){
        System.out.println("The state of instance object is: " + completed);
    }

    @Order(1)
    @Test
    void TestD(){
        System.out.println("Running test D");
        completed.append("1");
    }

    @Order(2)
    @Test
    void TestA(){
        System.out.println("Running test A");
        completed.append("2");
    }

    @Order(4)
    @Test
    void TestC(){
        System.out.println("Running test C");
        completed.append("4");
    }

    @Order(3)
    @Test
    void TestB(){
        System.out.println("Running test B");
        completed.append("3");
    }
}
