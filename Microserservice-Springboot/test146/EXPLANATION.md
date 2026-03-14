# Test 146: JWT Security Filter

Validating Bearer tokens on every API request before they reach controllers.

## Key Files:
- `JwtSecurityConfig.java`: Custom `JwtFilter` added before the default auth filter.
- `EXPLANATION.md`: How JWT makes sessions stateless.

## Concept:
The JWT Filter intercepts EVERY request. It reads the `Authorization: Bearer <token>` header, validates the signature, and sets the user's identity in Spring's SecurityContext. If the token is missing or invalid, it returns 401 immediately — no controller is reached.
