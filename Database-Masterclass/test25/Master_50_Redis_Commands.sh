# ============================================================================
# DATABASE MASTERCLASS: TEST 25 - THE 50 REDIS COMMANDS & PATTERNS
# ============================================================================

# --- 1. STRING (Basic Key-Value) ---
# 1. SET user:1:name "Vikas"
# 2. GET user:1:name
# 3. SETNX lock:order:101 "true" (Set if Not Exists - Atomic Locking)
# 4. SETEX session:123 3600 "data" (Set with Expiry in seconds)
# 5. INCR page_views (Atomic Increment)
# 6. INCRBY points 50
# 7. DECR inventory
# 8. MSET key1 "v1" key2 "v2" (Multiple Set)
# 9. MGET key1 key2
# 10. APPEND msg " World"

# --- 2. HASH (Perfect for Objects) ---
# 11. HSET user:1 name "Vikas" email "v@test.com" age 25
# 12. HGET user:1 name
# 13. HGETALL user:1
# 14. HDEL user:1 age
# 15. HEXISTS user:1 email
# 16. HINCRBY user:1 points 10
# 17. HKEYS user:1
# 18. HVALS user:1
# 19. HLEN user:1
# 20. HMGET user:1 name email

# --- 3. LIST (Queues & Stacks) ---
# 21. LPUSH task_queue "task1" (Add to start)
# 22. RPUSH task_queue "task2" (Add to end)
# 23. LPOP task_queue (Remove from start)
# 24. RPOP task_queue (Remove from end)
# 25. LLEN task_queue
# 26. LRANGE task_queue 0 -1 (Get all items)
# 27. LTRIM task_queue 0 99 (Keep only latest 100 items - Rolling log)
# 28. BRPOP task_queue 30 (Blocking Pop - Wait 30s if empty - Job Worker)
# 29. LINDEX task_queue 0
# 30. LREM task_queue 1 "task1"

# --- 4. SET (Uniqueness & Tags) ---
# 31. SADD user:1:tags "java" "redis" "spring"
# 32. SMEMBERS user:1:tags
# 33. SISMEMBER user:1:tags "java"
# 34. SREM user:1:tags "spring"
# 35. SCARD user:1:tags (Count)
# 36. SINTER user:1:tags user:2:tags (Intersection - Common Friends/Interests)
# 37. SUNION user:1:tags user:2:tags
# 38. SDIFF user:1:tags user:2:tags (Difference)
# 39. SMOVE user:1:tags user:2:tags "java"
# 40. SRANDMEMBER user:1:tags (Random pick - Lucky Draw)

# --- 5. SORTED SET (Leaderboards) ---
# 41. ZADD leaderboard 100 "Vikas" 150 "Rahul" 80 "Amit"
# 42. ZRANGE leaderboard 0 -1 WITHSCORES (Get all by rank)
# 43. ZREVRANGE leaderboard 0 -1 WITHSCORES (Get top performers)
# 44. ZRANK leaderboard "Vikas" (Get rank of a user)
# 45. ZSCORE leaderboard "Rahul" (Get points)
# 46. ZINCRBY leaderboard 10 "Amit"
# 47. ZCOUNT leaderboard 100 200 (Count users with scores between 100-200)
# 48. ZREM leaderboard "Amit"
# 49. ZRANGEBYSCORE leaderboard 100 200
# 50. ZCARD leaderboard (Total players)

# ============================================================================
# --- BONUS: ADMIN & PUB/SUB ---
# PUBLISH news_chan "Hello World"
# SUBSCRIBE news_chan
# FLUSHALL (Delete everything - DANGER)
# INFO (System status)
# EXPIRE key 10
# TTL key
# ============================================================================
