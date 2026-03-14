# Test 29: Handlers and Interceptors

Control the request flow.

## Interceptor vs Filter:
- **Filter**: Part of the Servlet container. Runs before Spring. Useful for security or logging raw requests.
- **Interceptor**: Part of Spring MVC. Has access to Spring "Handler" (the Controller method). Useful for cross-cutting concerns like measuring execution time.

## Lifecycle:
1. `preHandle()`: Before controller runs. 
2. `postHandle()`: After controller, before view rendering.
3. `afterCompletion()`: After EVERYTHING is done.
