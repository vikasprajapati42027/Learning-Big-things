# Test 18: Custom Security Configuration

Don't want all endpoints protected? Want a custom login page? This is where you configure it.

## Key Concepts:
- **`HttpSecurity`**: The main object used to configure security rules.
- **`permitAll()`**: Makes an endpoint accessible to everyone (anonymous).
- **`authenticated()`**: Requires the user to be logged in.
- **`anyRequest()`**: A catch-all for anything not specifically matched.

## Why Form Login?
Basic Auth asks for credentials on every request. **Form Login** uses a session (Cookie) to keep you logged in after the first time.
