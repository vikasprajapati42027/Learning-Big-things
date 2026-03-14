# Test 132: JPA Projections

Fetching only the columns you need instead of the entire entity.

## Key Files:
- `ProjectionController.java`: Shows interface-based projections to exclude the salary field.
- `EXPLANATION.md`: Performance benefit of selecting partial data.

## Concept:
Fetching `SELECT *` when you only need `name` and `department` wastes bandwidth and CPU. A JPA Projection tells Spring "Only SELECT these 2 columns from the SQL query" — making it faster and preventing accidental data leaks.
