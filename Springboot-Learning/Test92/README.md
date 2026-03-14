# Test 92: Clean Architecture

The ultimate separation of concerns.

## The Dependency Rule:
Source code dependencies can only point **inwards**, toward higher-level policies (The Core).
The Core (Use Cases/Entities) should NEVER know anything about the Database, the Web, or Spring Boot itself.

## Benefit:
- **Independent of Framework**: You can use Spring, Quarkus, or Micronuat - the core logic doesn't change.
- **Testable**: You can test the business logic without any external system.
- **Independent of UI**: Changes in the Web UI don't affect the business rules.
