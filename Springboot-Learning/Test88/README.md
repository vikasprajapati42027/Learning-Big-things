# Test 88: SAGA Orchestration

The "Conductor" of microservices.

## How it works:
A central controller (Orchestrator) tells the participants what local transactions to execute. 
- "Inventory, decement stock." -> "OK".
- "Payment, charge card." -> "Fail".
- "Inventory, increment stock (Undo)."

## Pros:
- Easy to understand the workflow in one place.
- Avoids cyclic dependencies between services.

## Cons:
- Risk of over-centralizing logic in the orchestrator.
