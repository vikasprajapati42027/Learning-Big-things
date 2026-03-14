# Test 84: Spring Cloud Contract

Testing APIs without breaking them.

## The Problem:
`Order Service` depends on `User Service`. If `User Service` changes its JSON format, `Order Service` breaks. You usually only find this when you deploy (too late!).

## The Solution:
1. **The Contract**: Both teams agree on a Groovy/YAML file defining the API.
2. **Stub**: Spring generates a "Mock" server for the consumer.
3. **Verification**: Spring generates a test for the producer to ensure it still follows the contract.
No more "Breaking Changes"!
