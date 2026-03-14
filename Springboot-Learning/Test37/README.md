# Test 37: Transaction Management (@Transactional)

The "ACID" properties for your business logic.

## How it works:
Spring creates a proxy around your `@Transactional` class.
1. It opens a database connection.
2. It sets `auto-commit = false`.
3. It runs your method.
4. If successful, it calls `commit()`.
5. If a `RuntimeException` occurs, it calls `rollback()`.

## Important Note:
By default, Spring only rolls back for **Unchecked Exceptions** (RuntimeExceptions). If you want it to roll back for Checked Exceptions, use:
`@Transactional(rollbackFor = Exception.class)`
