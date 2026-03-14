# Test 90: Domain-Driven Design (DDD)

Modeling your code after real-world business complex logic.

## Key Files:
- `OrderDomain.java`: Shows a "Rich Domain Model" where logic lives inside the object, not just in services.
- `EXPLANATION.md`: Ubiquitous Language and Bounded Contexts.

## Concept:
In simple apps, objects are just data containers. In DDD, objects have "Behavior". If an Order can be "Paid", that logic belongs inside the `Order` class, ensuring the business rules are always followed.
