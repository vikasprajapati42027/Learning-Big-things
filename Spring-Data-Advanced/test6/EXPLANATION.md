# Test 6: Derived Query Methods

## 🪄 1. Concept
Spring Data JPA creates SQL for you based on the method name.
`findByStatus(String status)` -> `select * from users where status = ?`
