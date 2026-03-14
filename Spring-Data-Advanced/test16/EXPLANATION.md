# Test 16: Optimistic Locking

## 🔒 1. Concept
Hibernate checks the `version` column before updating. If another user updated the row already, an exception is thrown.
