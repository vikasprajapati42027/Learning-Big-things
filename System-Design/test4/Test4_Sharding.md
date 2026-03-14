# Test 4: Database Sharding

## Simple Explanation
Split one huge table across multiple databases.
Instead of 100M rows in one DB, you have 25M rows in 4 databases.

## Sharding Strategies

### Hash-based
```
shard_id = hash(user_id) % number_of_shards
user_id 1001 → hash = 3 → DB_3
user_id 1002 → hash = 1 → DB_1
```
Pros: Even distribution.
Cons: Adding a new shard requires redistributing data.

### Range-based
```
user_id 1-1M       → DB_1
user_id 1M-2M      → DB_2
user_id 2M-3M      → DB_3
```
Pros: Easy to add shards.
Cons: "Hot spots" if most users are in one range.

## Consistent Hashing
Solves the redistribution problem.
When you add a new shard, only a small % of data moves (not ALL data!).
Used by: Amazon DynamoDB, Cassandra, Redis Cluster.

## Downsides of Sharding
- Cross-shard JOIN queries are impossible → denormalize data
- Transactions across shards are very complex
- Schema changes must be applied to ALL shards
