# Test 137: Bulkhead Pattern

Isolating failures so they don't crash the whole system.

## Key Files:
- `BulkheadController.java`: Demonstrates the `@Bulkhead` annotation from Resilience4j.
- `EXPLANATION.md`: Ships, Compartments, and Thread Isolation.

## Concept:
In a ship, a "Bulkhead" is a wall that stops a leak from sinking the entire vessel. In Spring, the Bulkhead pattern limits how many threads one specific service can use. If Service A starts failing and taking a long time, it won't consume all system threads, allowing Service B to continue working perfectly.
