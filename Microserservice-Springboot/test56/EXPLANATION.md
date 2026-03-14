# Test 56: Reactive Repositories (R2DBC)

The final piece of the reactive puzzle: Non-blocking Databases.

## Key Files:
- `ReactiveUserRepository.java`: Demonstrates `ReactiveCrudRepository`.
- `EXPLANATION.md`: Why JDBC is blocking and R2DBC is the solution.

## Concept:
Old JDBC blocks a thread while waiting for the database. R2DBC allows the thread to do other work while the database is thinking, making it much more efficient for high-scale apps.
