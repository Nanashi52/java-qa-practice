package com.qa.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserValidator — модульные тесты")
class UserValidatorTest {

    @ParameterizedTest
    @CsvSource({"test@mail.ru, true", "user.name@company.co, true", "a@b.cc, true"})
    @DisplayName("Валидные email")
    void isValidEmailTrue(String email) {
        assertTrue(UserValidator.isValidEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid", "@mail.ru", "test@", "test@.ru", "test@mail", ""})
    @DisplayName("Невалидные email")
    void isValidEmailFalse(String email) {
        assertFalse(UserValidator.isValidEmail(email));
    }

    @Test
    @DisplayName("null email — невалиден")
    void isValidEmailNull() {
        assertFalse(UserValidator.isValidEmail(null));
    }

    @ParameterizedTest
    @CsvSource({"Password1, true", "Abc12345, true", "StrongPass9, true"})
    @DisplayName("Валидные пароли")
    void isValidPasswordTrue(String password) {
        assertTrue(UserValidator.isValidPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"weak", "nosdigits", "NoDigitHere", "12345678", "abcdefgh"})
    @DisplayName("Невалидные пароли")
    void isValidPasswordFalse(String password) {
        assertFalse(UserValidator.isValidPassword(password));
    }

    @ParameterizedTest
    @CsvSource({"0, true", "18, true", "150, true"})
    @DisplayName("Валидный возраст")
    void isValidAgeTrue(int age) {
        assertTrue(UserValidator.isValidAge(age));
    }

    @ParameterizedTest
    @CsvSource({"-1, false", "151, false", "200, false"})
    @DisplayName("Невалидный возраст")
    void isValidAgeFalse(int age) {
        assertFalse(UserValidator.isValidAge(age));
    }

    @ParameterizedTest
    @CsvSource({"konstantin, true", "user_123, true", "abc, true"})
    @DisplayName("Валидное имя пользователя")
    void isValidUsernameTrue(String username) {
        assertTrue(UserValidator.isValidUsername(username));
    }

    @Test
    @DisplayName("Невалидное имя пользователя — слишком короткое")
    void isValidUsernameTooShort() {
        assertFalse(UserValidator.isValidUsername("ab"));
    }

    @Test
    @DisplayName("Невалидное имя пользователя — слишком длинное")
    void isValidUsernameTooLong() {
        assertFalse(UserValidator.isValidUsername("aaaaaaaaaaaaaaaaaaaaa"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"user name", "user!", "user@name"})
    @DisplayName("Невалидное имя пользователя — спецсимволы")
    void isValidUsernameInvalidChars(String username) {
        assertFalse(UserValidator.isValidUsername(username));
    }

    @Test
    @DisplayName("null username — невалиден")
    void isValidUsernameNull() {
        assertFalse(UserValidator.isValidUsername(null));
    }
}
