# Test 15: Introduction to Testing

Spring Boot makes testing easy with built-in support for JUnit 5, Mockito, and AssertJ.

## Types of Tests:
- **Unit Test**: Test one class without Spring context (fast).
- **Integration Test**: Test how components work together with Spring context (`@SpringBootTest`).
- **Slicing Tests**: Test only one part (e.g., `@WebMvcTest` for controllers only).

## Tools:
- **JUnit 5**: The testing framework.
- **Mockito**: For creating "mock" objects to replace real dependencies.
- **AssertJ**: For readable assertions (`assertThat(x).isEqualTo(y)`).
