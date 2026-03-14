# Test 79: Database Migrations (Flyway)

Version-controlling your database schema just like you version-control your code.

## Key Files:
- `FlywayApplication.java`: Main app (Flyway auto-detects SQL scripts).
- `V1__create_users_table.sql`: The first migration (creates the users table).
- `EXPLANATION.md`: Why everyone hates manual SQL scripts.

## Concept:
When you have 5 developers and 3 environments (Dev, Staging, Prod), each person may make different DB changes. Flyway ensures ALL SQL changes are stored in version-controlled files and applied in the exact same order everywhere, automatically.
