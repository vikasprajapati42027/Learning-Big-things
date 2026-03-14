# Test 144: JPA Specifications (Dynamic Queries)

Building flexible search queries at runtime without writing hundreds of repository methods.

## Key Files:
- `SpecificationController.java`: Dynamically combines search criteria using `Specification<T>`.
- `EXPLANATION.md`: Why you need Specifications for search APIs.

## Concept:
A search API needs to filter by many optional combinations. Writing `findByTypeAndPriceLessThan`, `findByType`, `findByPrice` etc. for every combo is insane. Specifications let you compose criteria dynamically: "Brand=Toyota AND Price≤500000" with simple, reusable building blocks.
