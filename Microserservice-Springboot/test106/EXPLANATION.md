# Test 106: Database Sharding

Splitting a giant database into smaller, faster pieces.

## Key Files:
- `ShardingService.java`: Logic for determining which database node contains a specific user's data.
- `EXPLANATION.md`: Horizontal vs Vertical scaling.

## Why use it?
A single database can only handle so much. Sharding splits your 100 million users into two 50-million-user databases. This doubles your write speed and keeps the system fast even as it grows massive.
