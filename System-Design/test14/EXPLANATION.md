# Test 14: Circuit Breaker Pattern

## Simple Explanation
In Microservices, if Service A calls Service B and Service B is slow/down, Service A will hang. If 100 people call Service A, all 100 threads will hang → Service A crashes too! This is called **Cascading Failure**.

## The Solution: Circuit Breaker
It acts like an electrical circuit breaker in your house.

1. **CLOSED**: Everything is fine. Requests flow normally.
2. **OPEN**: Too many failures detected. Requests are BLOCKED instantly (returns an error/fallback) to give Service B time to recover.
3. **HALF-OPEN**: After a delay, it allows a FEW requests to see if Service B is back. If they pass, it CLOSES the circuit.

## Fallback Method
When the circuit is OPEN, instead of an Error, you can return cached data or a friendly message. 
*Example*: "Service is busy, showing your offline favorites instead."

## Tool: Resilience4j
This is the modern standard for Spring Boot to implement Circuit Breakers, Rate Limiters, and Retries.
