# Test 41: Spring Boot with Redis

Move from local cache to distributed cache.

## Why Redis?
- **Shared**: If you have 5 servers, they all see the same cache.
- **Persistent**: Cache is not lost when the app restarts.
- **Fast**: It's an in-memory database.

## Session Management:
You can also store HTTP Sessions in Redis using `spring-session-data-redis`. This allows "Stateless" servers while still having "Session" data for users.
