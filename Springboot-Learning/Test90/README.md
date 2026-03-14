# Test 90: Domain-Driven Design (DDD)

Speaking the business language in code.

## Ubiquitous Language:
Developers and Business Owners should use the SAME terms. If the business calls it a "Subscription", don't call it a "UserProductPlan" in code.

## Bounded Context:
In a large app, a "Product" means different things to different people.
- **Catalog Context**: Name, Description, Price.
- **Warehouse Context**: Weight, Dimensions, Aisle Number.
In DDD, you create TWO separate models instead of one giant "God Object".
