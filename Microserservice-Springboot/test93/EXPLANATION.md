# Test 93: Saga Pattern (Choreography)

Managing distributed transactions using events.

## Key Files:
- `SagaChoreographyService.java`: Logic for event-based coordination.
- `EXPLANATION.md`: Why we don't use 2PC (Two-Phase Commit) in microservices.

## Why use it?
If you have 3 services (Order, Inventory, Payment), you can't use a single database transaction. Saga ensures that if Payment fails, a "Compensating Transaction" is triggered to undo the Inventory reservation.
