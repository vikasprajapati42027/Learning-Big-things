# Test 85: API Gateway Global Filters

Running logic for every single request that enters the system.

## Key Files:
- `GlobalLoggingFilter.java`: Demonstrates a filter that logs every outgoing response.
- `EXPLANATION.md`: Use cases like Token Validation and Logging.

## Why use it?
Instead of adding logging or auth code to 10 different services, you add it once to the Gateway. It intercepts every request, checks the token, logs the IP, and then passes it to the correct microservice.
