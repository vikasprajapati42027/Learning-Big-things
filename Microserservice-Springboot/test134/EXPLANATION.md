# Test 134: Integration Testing (@SpringBootTest)

Testing the complete application stack — from HTTP request to database.

## Key Files:
- `IntegrationTest.java`: Starts a real server on a random port and makes actual HTTP calls.
- `EXPLANATION.md`: Unit tests vs Integration tests vs E2E tests.

## Concept:
An integration test starts your ENTIRE Spring context (all beans, config, filters). It's slower than a unit test but proves that everything works together. Use it to test critical happy paths like "User can register and login."
