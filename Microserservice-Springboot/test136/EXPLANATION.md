# Test 136: Circuit Breaker (Resilience4j)

Stopping cascading failures before they take down the whole system.

## Key Files:
- `OrderServiceWithCircuitBreaker.java`: `@CircuitBreaker` with a fallback method.
- `EXPLANATION.md`: CLOSED vs OPEN vs HALF-OPEN states.

## Concept:
If `inventory-service` fails 5 times in a row, the circuit "OPENS" — all further calls immediately return the fallback without even trying (saving your threads). After 60 seconds, it tries once more (HALF-OPEN). If successful, it CLOSES again and normal traffic resumes.
