# Test 89: SAGA Choreography

Decentralized coordination.

## How it works:
Each service performs its transaction and publishes an event. Other services listen to those events and decide if they need to act.
- `Inventory` decements stock -> Publishes `StockDecremented`.
- `Payment` sees `StockDecremented` -> Tries to charge card -> Fails -> Publishes `PaymentFailed`.
- `Inventory` sees `PaymentFailed` -> Adds stock back.

## Pros:
- Highly decoupled. No single point of failure.

## Cons:
- Hard to track which service is currently doing what.
- Hard to debug if many events are flying around.
