# Test 47: Resilience (Circuit Breaker)

Stop the "Cascading Failure" effect.

## The Problem:
If `Service A` calls `Service B`, and `Service B` is slow, `Service A`'s threads will fill up, potentially crashing `Service A`.

## The Solution (Circuit Breaker):
1. **Closed**: Everything is fine.
2. **Open**: Service B is failing. Stop calling it immediately. Return a **Fallback** result.
3. **Half-Open**: Try a few requests to see if B is back up.

## Fallback:
Always have a plan B! (e.g., return cached data or a friendly error message).
