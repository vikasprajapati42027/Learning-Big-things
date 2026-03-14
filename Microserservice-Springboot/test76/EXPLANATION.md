# Test 76: Multiple DataSources

Connecting to two different databases from the same Spring Boot app.

## Key Files:
- `MultipleDataSourceConfig.java`: Defines two separate DataSource beans.
- `EXPLANATION.md`: Read replica pattern and DB segregation.

## Concept:
In production, you often split reads (fast slave DB) and writes (master DB) for performance. This config shows how one service can connect to a primary write database AND a separate read-only analytics database simultaneously.
