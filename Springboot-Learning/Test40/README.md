# Test 40: Spring Boot with MongoDB (NoSQL)

Sometimes SQL is not the best fit. 

## When to use MongoDB?
- Unstructured or rapidly changing data.
- High write loads.
- Large amounts of data that don't need complex Joins.

## Spring Data magic:
It works exactly like JPA! You still get Repositories, derived query methods, and automatic ID generation. The only change is the dependency and the `@Document` annotation.
