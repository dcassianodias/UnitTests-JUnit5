package com.danilodias;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodOrderedRandomlyTest {

    @Test
    void TestA(){
        System.out.println("Running test A");
    }

    @Test
    void TestB(){
        System.out.println("Running test B");
    }

    @Test
    void TestC(){
        System.out.println("Running test C");
    }

    @Test
    void TestD(){
        System.out.println("Running test D");
    }
}
