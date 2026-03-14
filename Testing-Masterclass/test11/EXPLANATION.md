# Test 11: Unit Testing vs Integration Testing

## 1. Unit Testing
Testing the SMALLEST piece of code (one method/one class) in isolation.
- **Mocks**: Everything else is FAKED.
- **Speed**: Super fast (milliseconds).
- **Goal**: Check logic inside a function.
- **Tool**: JUnit + Mockito.

## 2. Integration Testing
Testing components WORKING TOGETHER (e.g., Service + Database).
- **Mocks**: Real database or TestContainers are used.
- **Speed**: Slower (seconds).
- **Goal**: Check if components communicate correctly.
- **Tool**: `@SpringBootTest`.

## The Testing Pyramid
```
      /  E2E  \      ← Fewest (Slow/Fragile)
     /─────────\
    / Integration \
   /───────────────\
  /      Unit       \  ← Most (Fast/Reliable)
 /───────────────────\
```
**Tip**: 70-80% of your tests should be **Unit Tests**!
