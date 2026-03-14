# Test 114: HTTP Interceptors

Intercepting every request before it reaches your controller.

## Key Files:
- `LoggingInterceptor.java`: Logs the method, URL, IP, and response status for every API call.
- `EXPLANATION.md`: Interceptors vs Filters vs AOP.

## Concept:
Think of Interceptors as a security guard at the door. Every request must pass through the guard before reaching the controller (preHandle). After the request is processed, the guard logs the result (afterCompletion). Perfect for auth checks, logging, and timing.
