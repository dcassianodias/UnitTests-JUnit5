package com.danilodias;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(expectedResult, result, "4/2 nao gerou o resultado 2");
    }

    @DisplayName("Division by Zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Division by Zero ");
        //Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        //Act & Assert
        ArithmeticException actualException = (ArithmeticException)assertThrows(ArithmeticException.class, () -> {
            this.calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have throws an Arithmetic exception");

        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Danilo", "Viviane", "Thabata"})
    void valueSourceDemonstration(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @DisplayName("Test integer subtraction [minuend, subtraend, expectedResult")
    @ParameterizedTest
    //@MethodSource
//    @CsvSource({
//            "33, 1, 32",
//            "23, 11, 12",
//            "50, 8, 42"
//    })
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void integerSubtraction(int minuend, int subtraend, int expectedResult) {
        System.out.println("Running Test " + minuend + " - " + subtraend + " = " + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend, subtraend);

        assertEquals(expectedResult, actualResult, () ->
                minuend + " - " + subtraend + " = " + expectedResult);
    }

//    private static Stream<Arguments> integerSubtraction() {
//        return Stream.of(
//                Arguments.of(33, 1, 32),
//                Arguments.of(54, 1, 53),
//                Arguments.of(24, 1, 23)
//        );
//    }
}
