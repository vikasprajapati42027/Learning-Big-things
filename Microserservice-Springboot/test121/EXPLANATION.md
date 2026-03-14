# Test 121: Pagination & Sorting

Loading large datasets in small, manageable pages.

## Key Files:
- `PaginatedController.java`: Shows `Pageable`, `PageRequest`, and `Sort`.
- `EXPLANATION.md`: Why you should NEVER return all rows from a database.

## Concept:
If you have 1 million posts in the DB and someone calls `/posts`, sending all 1 million at once will crash both the server and the client. Pagination returns a slice (e.g., posts 1-10), and the client asks for the next page when ready.
