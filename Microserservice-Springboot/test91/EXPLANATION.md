# Test 91: Hexagonal Architecture (Ports and Adapters)

Decoupling business logic from external technologies.

## Key Files:
- `HexagonalStructure.java`: Shows the separation between the 'Port' (Logic) and the 'Adapter' (Technology).
- `EXPLANATION.md`: Why you should be able to swap your database or payment provider without touching core logic.

## Concept:
The center of your app (the Hexagon) is pure business rules. The "Adapters" are the plugins (SQL, Mongo, Stripe). You can swap the plugins easily because the core logic only talks to "Ports" (Interfaces).
