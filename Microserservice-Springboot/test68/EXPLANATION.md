# Test 68: MongoDB Integration

Document-oriented NoSQL storage for flexible data.

## Key Files:
- `ProductRepository.java`: Entity and Repository with custom queries.
- `ProductController.java`: Full CRUD REST API.
- `EXPLANATION.md`: When to choose MongoDB over SQL.

## Concept:
MongoDB stores data as JSON-like Documents instead of rows & columns. This is great when data has a flexible structure — e.g., one product has 3 attributes and another has 20. SQL would require lots of null columns; MongoDB handles it naturally.
