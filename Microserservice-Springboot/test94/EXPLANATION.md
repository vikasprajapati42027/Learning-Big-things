# Test 94: Saga Pattern (Orchestration)

Centralized control of a distributed transaction.

## Key Files:
- `SagaOrchestrator.java`: The "Manager" class that tells every service when to act.
- `EXPLANATION.md`: Orchestration vs Choreography.

## Concept:
Unlike Choreography (where services talk to each other via events), Orchestration uses a "Brain" (The Orchestrator). It calls Service A, waits for success, then calls Service B. If something fails, the "Brain" is responsible for calling everyone else to "Undo" their changes.
