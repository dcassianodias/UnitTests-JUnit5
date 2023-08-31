package com.danilodias;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {
    Calculator calculator;

    CalculatorTest() {
    }

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        this.calculator = new Calculator();
        System.out.println("Executing @BeforeEach method");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method");
    }

    @DisplayName("Test 4/2 = 2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Running Test 4/2 = 2 ");
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;
        int result = this.calculator.integerDivision(dividend, divisor);
        Assertions.assertEquals(expectedResult, result, "4/2 nao gerou o resultado 2");
    }

    @DisplayName("Division by Zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Division by Zero ");
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException actualException = (ArithmeticException)Assertions.assertThrows(ArithmeticException.class, () -> {
            this.calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have throws an Arithmetic exception");
        Assertions.assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

    @DisplayName("Test integer subtraction [minuend, subtraend, expectedResult")
    @ParameterizedTest
    @MethodSource
    void integerSubtraction(int minuend, int subtraend, int expectedResult) {
        System.out.println("Running Test " + minuend + " - " + subtraend + " = " + expectedResult);
        int result = this.calculator.integerSubtraction(minuend, subtraend);
        Assertions.assertEquals(expectedResult, result, () -> {
            return "" + minuend + " - " + subtraend + " Não produziu: " + expectedResult;
        });
    }

    private static Stream<Arguments> integerSubtraction() {
        return Stream.of(Arguments.of(new Object[]{33, 1, 32}), Arguments.of(new Object[]{54, 1, 53}), Arguments.of(new Object[]{24, 1, 23}));
    }
}
