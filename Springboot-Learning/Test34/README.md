# Test 34: JPA Derived Query Methods

Write methods, not SQL.

## Keywords:
- `findBy`: The prefix.
- `And`, `Or`: Combine fields.
- `Is`, `Equals`: Exact match (default).
- `Between`, `LessThan`, `GreaterThan`.
- `Like`, `StartingWith`, `Containing`.
- `OrderByFieldNameDesc`.

## Tip:
If your method name gets too long (e.g., `findByNameAndCategoryAndPriceGreaterThanAndActiveTrue`), it's better to use `@Query` instead for readability.
