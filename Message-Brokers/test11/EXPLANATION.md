# Test 11: Kafka Log Compaction

## Simple Explanation
Usually, Kafka deletes old messages after some time (Retention). But for "State" data (like user profiles or current stock price), we only care about the **LATEST** value for each Key.

**Log Compaction** ensures that Kafka always keeps at least the last known value for each message key.

## How it works
If you have:
1. `key:user1, value:v1`
2. `key:user2, value:v2`
3. `key:user1, value:v3`

A normal topic eventually deletes all 3. 
A **Compacted** topic will keep #2 and #3, but delete #1 because #3 superseded it.

## When to use?
- Reconstructing State (e.g., in Kafka Streams KTable).
- Storing configurations or "Source of Truth" data.
- Reducing disk space usage for long-lived keys.

## Configuration
Inside topic settings: `cleanup.policy=compact`.
