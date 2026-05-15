# Java QA Practice

Educational project demonstrating unit testing skills in Java with JUnit 5.

## Stack

- Java 17
- JUnit 5
- Maven

## Test Coverage

| Class | Description | Tests |
|-------|-------------|-------|
| `Calculator` | Arithmetic operations, even checks, factorial | 23 |
| `StringUtils` | Palindromes, vowel counting, reverse, truncate | 21 |
| `UserValidator` | Email, password, age, username validation | 33 |

## Approaches Used

- Parameterized tests (`@ParameterizedTest`, `@CsvSource`, `@ValueSource`)
- Exception testing (`assertThrows`)
- Display names via `@DisplayName`
- Boundary values and negative scenarios

## Run

```bash
mvn test
```
