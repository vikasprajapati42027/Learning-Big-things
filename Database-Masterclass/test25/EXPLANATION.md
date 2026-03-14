# Test 25: Redis Masterclass (50 Commands)

## 1. What is Redis?
Redis stands for **REmote DIctionary Server**. It is an In-Memory data structure store. Because it lives in RAM (not on disk), it is 1,000x faster than MySQL for simple key-value lookups.

## 2. When to use which Data Structure?
- **Strings**: Simple caching, session tokens, and atomic counters (Page views).
- **Hashes**: Storing objects (User profile, Product info). Much more efficient than storing JSON strings.
- **Lists**: Message queues, Recent activity feeds (LTRIM), Job handling (BRPOP).
- **Sets**: Unique items (Tags, IPs that visited today), Social graphs (Common friends).
- **Sorted Sets**: Real-time Leaderboards, Rate limiting (Sliding window), Priority queues.

## 3. The "SETNX" Locking Pattern (Q3)
This is a standard Senior Java Interview question. How do you ensure only one server processes a task?
Answer: Use `SETNX` (Set if Not Exists). If it returns 1, you got the lock. If 0, someone else is already doing it.

## 4. Eviction Policies
Since RAM is expensive, Redis has "Eviction Policies".
- **LRU (Least Recently Used)**: Deletes the stuff you haven't touched in a while.
- **LFU (Least Frequently Used)**: Deletes the stuff that isn't popular.
- **TTL**: Data automatically disappears after a set time.
