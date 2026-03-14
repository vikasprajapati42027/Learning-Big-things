# Test 71: Redis Pub/Sub

Lightweight, real-time messaging between services.

## Key Files:
- `RedisPubSubConfig.java`: Demonstrates setting up a listener for a specific "Topic".
- `EXPLANATION.md`: Comparing Redis Pub/Sub vs Kafka.

## Why use it?
For simple, fast, and real-time communication like a Chat App or sending live notifications. It's much simpler to set up than Kafka but doesn't keep history—if a service is offline, it misses the message!
