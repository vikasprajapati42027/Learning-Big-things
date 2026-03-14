# Test 92: CQRS Pattern

Separating "Write" operations from "Read" operations.

## Key Files:
- `CqrsPattern.java`: Shows separate services for Commands (editing data) and Queries (reading data).
- `EXPLANATION.md`: Why complex apps need different models for reading and writing.

## Why use it?
Writing data usually requires complex validation. Reading data needs to be super fast. By separating them, you can optimize your database for speeds (Reads) without making the logic (Writes) messy.
