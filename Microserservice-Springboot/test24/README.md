# Test 24: Contract Testing (Pact)

Ensuring the "Producer" doesn't break the "Consumer".

## Scenario:
You change the `department-service` to return `deptName` instead of `name`. Suddenly, the `employee-service` crashes.

## The Solution:
The "Consumer" (Employee Service) writes a **Contract** (a JSON file) of what it expects.
The "Producer" (Department Service) must pass this test before its code can be merged. 
If the Producer tries to change the name, the test fails immediately!
