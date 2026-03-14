# Test 3: Caching Strategies

## Why Cache?
Database reads take 10-100ms. Cache reads take < 1ms. 100x speedup!

## 4 Main Strategies

### 1. Cache-Aside (Most Common)
```
App → Check Cache → Miss → Read DB → Write to Cache → Return data
App → Check Cache → Hit  → Return data (fast!)
```
Used By: Redis with Spring @Cacheable

### 2. Write-Through
Write to Cache AND Database at the same time (synchronously).
Pros: Cache always fresh.  
Cons: Every write is slower (2 operations).

### 3. Write-Behind (Write-Back)  
Write to Cache only → Queue → Database written LATER (async).
Pros: Writes are fast.  
Cons: If crash before flush → data loss!

### 4. Read-Through
Cache sits in front of DB, automatically fetches from DB on miss.
Similar to Cache-Aside but cache itself handles the DB call.

## What NOT to Cache
- User-specific sensitive data (privacy risk)
- Rapidly changing data (cache invalidation is hard)
- Small datasets (overhead not worth it)
