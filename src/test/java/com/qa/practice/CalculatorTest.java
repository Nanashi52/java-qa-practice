package com.qa.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator — модульные тесты")
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Сложение двух положительных чисел")
    void addPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Сложение с нулём")
    void addWithZero() {
        assertEquals(7, calculator.add(7, 0));
        assertEquals(7, calculator.add(0, 7));
    }

    @Test
    @DisplayName("Сложение отрицательных чисел")
    void addNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @ParameterizedTest
    @CsvSource({"2,3,5", "0,0,0", "-1,1,0", "100,200,300"})
    @DisplayName("Параметризованное сложение")
    void addParameterized(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @Test
    @DisplayName("Вычитание")
    void subtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-8, calculator.subtract(-3, 5));
    }

    @Test
    @DisplayName("Умножение")
    void multiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-6, calculator.multiply(-2, 3));
    }

    @Test
    @DisplayName("Деление")
    void divide() {
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2, calculator.divide(-6, 3));
    }

    @Test
    @DisplayName("Деление на ноль — исключение")
    void divideByZero() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> calculator.divide(5, 0));
        assertEquals("Деление на ноль невозможно", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 100, 0})
    @DisplayName("Чётные числа")
    void isEvenTrue(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 99})
    @DisplayName("Нечётные числа")
    void isEvenFalse(int number) {
        assertFalse(calculator.isEven(number));
    }

    @Test
    @DisplayName("Факториал")
    void factorial() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(120, calculator.factorial(5));
        assertEquals(2432902008176640000L, calculator.factorial(20));
    }

    @Test
    @DisplayName("Факториал отрицательного — исключение")
    void factorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }

    @Test
    @DisplayName("Факториал слишком большого — исключение")
    void factorialTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(21));
    }
}
