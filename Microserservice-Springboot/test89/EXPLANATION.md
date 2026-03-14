# Test 89: Unit Testing (Mockito)

Testing business logic without touching real databases or external services.

## Key Files:
- `MockitoTest.java`: Full test showing `@Mock`, `@InjectMocks`, `when().thenReturn()`, and `verify()`.
- `EXPLANATION.md`: The AAA pattern (Arrange, Act, Assert).

## Concept:
Mockito creates a "Fake" version of your repository so you can test your service in isolation. You control the fake's behavior (`when...thenReturn`) and verify it was called correctly (`verify`). This way, tests are fast, reliable, and don't need a database.
