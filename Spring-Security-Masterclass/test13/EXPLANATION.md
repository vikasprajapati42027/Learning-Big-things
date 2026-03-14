# Test 13: SQL Injection Prevention

## Simple Explanation
SQL Injection happens when user input is treated as part of the SQL command itself. An attacker can use special characters like `'` or `--` to change what your query does.

## The Classic Attack
Input: `admin' OR '1'='1`
Original Query: `SELECT * FROM users WHERE username = 'USER_INPUT'`
Injected Query: `SELECT * FROM users WHERE username = 'admin' OR '1'='1'` 
Result: The condition `'1'='1'` is always true, so the attacker gets access to all users!

## The Fix: Bound Parameters (Placeholders)
When you use `:user` or `?`, the database engine treats the input as **DATA**, not as part of the **COMMAND**. No matter what the user types, it's just a string, and it can't change the query logic.

## Best Practice
- Use **Spring Data JPA** (Repository methods like `findByUsername` are safe by default).
- If using `EntityManager`, always use `.setParameter()`.
- **Never** build query strings using `+` or string formatting.
