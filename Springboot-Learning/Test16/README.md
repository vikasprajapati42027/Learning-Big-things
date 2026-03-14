# Test 16: Slice Testing (@DataJpaTest)

Sometimes you don't want to start the whole application just to test a repository.

## What is Slicing?
Spring Boot allows you to "slice" the context.
- **`@DataJpaTest`**: Only JPA related beans.
- **`@WebMvcTest`**: Only Controller related beans.
- **`@JsonTest`**: Only JSON serialization/deserialization.

## Benefits:
1. **Faster**: Only a small part of Spring starts.
2. **Deterministic**: It uses an in-memory database by default.
3. **Transactional**: Tests are rolled back after completion automatically.
