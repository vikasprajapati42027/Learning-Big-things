# Test 8: Password Security (BCrypt)

## Why Not Store Plain Text?
If your database is hacked, the attacker gets ALL passwords.
Those users probably use the same password on Gmail, banking, etc. — catastrophic!

## Why Not MD5/SHA1?
Attackers have "Rainbow Tables" — pre-computed lists of millions of MD5 hashes.
They instantly find: `5f4dcc3b5...` = `"password"`.

## Why BCrypt is Safe
1. **Salt**: Adds random data before hashing — same password gives different hash every time
2. **Slow by design**: BCrypt intentionally takes 0.1 seconds to hash. Brute-force takes years.
3. The **strength parameter** (4-31): Higher = slower. Default 10, use 12 for production.

## Code Comparison
```java
// NEVER do this
user.setPassword("mypassword");

// ALWAYS do this
user.setPassword(encoder.encode("mypassword"));
```

## Verify at Login
```java
encoder.matches(enteredPassword, storedHash);
// true  → Correct password!
// false → Wrong password!
```
