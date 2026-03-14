# Test 97: Microservices Testing (TestContainers)

Testing your code against real databases instead of "Mocks".

## Key Files:
- `EXPLANATION.md`: Logic for launching Docker containers during JUnit tests.

## Why use it?
H2 (In-memory DB) behaves differently than MySQL. TestContainers allows your JUnit tests to automatically start a REAL MySQL docker container, run the tests, and shut it down. This ensures your tests are 100% accurate.
