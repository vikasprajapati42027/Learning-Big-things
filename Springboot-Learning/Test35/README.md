# Test 35: JPA @Query Annotation

When derived methods aren't enough.

## JPQL:
- Database independent.
- Uses Java class and field names.
- Type safe.

## Native SQL:
- Fast.
- Allows using DB-specific features (like Postgres JSONB or Oracle hints).
- Use `nativeQuery = true`.

## Parameters:
- Named Parameters: `WHERE name = :name` (Recommended).
- Positional Parameters: `WHERE name = ?1`.
