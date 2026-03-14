# Test 72: Redis Streams

Persistent, reliable message queuing inside Redis.

## Key Files:
- `RedisStreamService.java`: Demonstrates adding records to a Stream.
- `EXPLANATION.md`: Redis Streams vs Pub/Sub.

## Why use it?
Pub/Sub is "Fire-and-Forget". If you aren't listening, you lose the message. Streams are "Fire-and-Store". They keep the messages so they can be read later, making them as reliable as Kafka but much lighter to run.
