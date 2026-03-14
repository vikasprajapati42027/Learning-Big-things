# Test 1: JUnit 5 Modern Features

## Key Annotations
| Annotation | Purpose |
|-----------|---------|
| `@Test` | Mark as test method |
| `@ParameterizedTest` | Run same test with different inputs |
| `@Nested` | Group related tests inside a class |
| `@DisplayName` | Human-readable test name |
| `@Disabled` | Skip this test (with a note why) |
| `@BeforeEach` | Setup before every test |
| `@AfterAll` | Cleanup after all tests run |

## Best Assertions
```java
assertEquals(expected, actual, "message");     // Values equal
assertThrows(Exception.class, () -> code());   // Code throws exception
assertAll("multiple checks",                   // All run even if one fails
    () -> assertEquals(1, x),
    () -> assertNotNull(y)
);
```

## @ParameterizedTest — Run once, test many cases
```java
@ParameterizedTest
@ValueSource(strings = {"", "  ", null})
void blankStrings(String s) { assertTrue(s == null || s.isBlank()); }
```
