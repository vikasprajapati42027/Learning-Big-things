# Test 95: OAuth2 Resource Server

Protecting your APIs with JWT (JSON Web Tokens).

## Key Files:
- `ResourceServerConfig.java`: Configuration to verify incoming JWT tokens.
- `EXPLANATION.md`: The flow between the Client, Keycloak (Auth Server), and the Resource Server.

## Why use it?
Instead of checking passwords, your microservice just looks at a "digital badge" (JWT). If the badge is signed by a trusted authority (like Keycloak or Okta), the request is allowed.
