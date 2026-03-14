# Test 10: Design Twitter / X Feed

## Core Challenge: Fan-Out Problem
When a celebrity with 10 million followers tweets, you need to update 10M feeds.

## Two Approaches

### Fan-Out on Write (Push Model)
```
Celebrity tweets → Immediately write to ALL 10M followers' feed caches
```
Pros: Read is instant (pre-computed).
Cons: Writing a single tweet = 10M writes! Celebrities slow the system.

### Fan-Out on Read (Pull Model)
```
User opens app → Fetch tweets from everyone they follow → Merge and sort
```
Pros: No pre-computation needed.
Cons: Each page load is slow for users who follow thousands of accounts.

## Twitter's Hybrid Solution
- **Normal users** → Fan-Out on Write (fast reads, low write volume)
- **Mega celebrities** → Fan-Out on Read (too many followers for push)
- When Elon tweets: Write to his tweet store → Each follower's feed fetches + merges on read

## Feed Storage (Redis)
```
User:123:feed → [tweet_id_10, tweet_id_9, tweet_id_7, ...]  (Redis Sorted Set by time)
```

## Timeline Algorithm
1. Get list of people user follows
2. Fetch latest 100 tweets from each (from tweet cache)
3. Merge all feeds sorted by time
4. Return top 50 tweets
