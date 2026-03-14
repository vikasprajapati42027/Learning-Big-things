# Test 38: Database Migrations (Flyway)

Your database schema should live in Git along with your code.

## Why use Migrations?
1. **Consistency**: Every developer has the exact same database structure.
2. **Automation**: The database updates automatically when the app starts.
3. **Safety**: No more "I forgot to run that SQL script" errors.

## Flyway:
- It looks for files in `src/main/resources/db/migration`.
- It keeps a table `flyway_schema_history` to track which scripts were already run.
- It runs new scripts only.
