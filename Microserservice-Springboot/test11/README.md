# Test 11: Security in Microservices (JWT & Gateway)

Protecting the "Front Door" of your system.

## The Strategy:
- **Authentication**: Done once at a dedicated Identity Service (or social login).
- **Token**: The user gets a **JWT (JSON Web Token)**.
- **Verification**: The **API Gateway** intercepts every request.
    - If the token is missing or invalid -> Reject with `401 Unauthorized`.
    - If valid -> Pass the request to the internal microservice.

## Benefit:
Internal microservices don't need to worry about security login logic. They can "trust" the gateway. 

**Pro Tip**: For high security, internal services should also verify the token, but the Gateway handles the heavy lifting first.
