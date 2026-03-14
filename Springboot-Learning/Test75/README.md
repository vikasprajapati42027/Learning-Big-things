# Test 75: Spring Statemachine

Management of complex workflows.

## Why use a Statemachine?
In simple apps, an `if (status == ...)` is fine. In complex apps, an Order might have 20 states! 
A Statemachine prevents invalid transitions (e.g., an Order cannot move from SHIPPED back to NEW).

## Key Components:
- **State**: Where the object is (e.g., `IN_PROGRESS`).
- **Event**: What triggers a change (e.g., `BUTTON_CLICK`).
- **Transition**: The move from A to B.
- **Action**: Code that runs during a transition (e.g., sending an email).
