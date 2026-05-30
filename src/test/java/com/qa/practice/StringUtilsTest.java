package com.qa.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils — модульные тесты")
class StringUtilsTest {

    @ParameterizedTest
    @CsvSource({"топот, true", "А роза упала на лапу Азора, true", "hello, false", "a, true", "абба, true"})
    @DisplayName("Проверка палиндромов")
    void isPalindrome(String input, boolean expected) {
        assertEquals(expected, StringUtils.isPalindrome(input));
    }

    @Test
    @DisplayName("isPalindrome — null — исключение")
    void isPalindromeNull() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.isPalindrome(null));
    }

    @ParameterizedTest
    @CsvSource({"hello, 2", "АЕИОУ, 5", "bcdfg, 0", "Привет мир, 3", "'', 0"})
    @DisplayName("Подсчёт гласных")
    void countVowels(String input, int expected) {
        assertEquals(expected, StringUtils.countVowels(input));
    }

    @Test
    @DisplayName("countVowels — null — исключение")
    void countVowelsNull() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.countVowels(null));
    }

    @Test
    @DisplayName("Реверс строки")
    void reverse() {
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("12345", StringUtils.reverse("54321"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isBlank — null и пустые строки")
    void isBlankTrue(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @Test
    @DisplayName("isBlank — строка из пробелов")
    void isBlankSpaces() {
        assertTrue(StringUtils.isBlank("   "));
    }

    @Test
    @DisplayName("isBlank — непустая строка")
    void isBlankFalse() {
        assertFalse(StringUtils.isBlank("text"));
    }

    @Test
    @DisplayName("truncate — строка короче лимита")
    void truncateShort() {
        assertEquals("hi", StringUtils.truncate("hi", 10));
    }

    @Test
    @DisplayName("truncate — строка длиннее лимита")
    void truncateLong() {
        assertEquals("Hello W...", StringUtils.truncate("Hello World", 7));
    }

    @Test
    @DisplayName("truncate — null — исключение")
    void truncateNull() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(null, 5));
    }

    @Test
    @DisplayName("truncate — отрицательный лимит — исключение")
    void truncateNegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("text", -1));
    }
}
