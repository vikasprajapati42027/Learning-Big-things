# Test 19: SAGA Pattern (Orchestration)

The "Conductor" approach.

## How it works:
Instead of a dance, you have a **Manager**.
1. **The Orchestrator**: Tells Service A "Do this".
2. **Service A**: Completes and tells Orchestrator "Done".
3. **The Orchestrator**: Tells Service B "Now do this".

## Why use it?
It's easier to understand and debug when you have a very complex workflow (e.g., a 10-step Insurance claim process). You can look at one file and see exactly what the current state of a request is.
