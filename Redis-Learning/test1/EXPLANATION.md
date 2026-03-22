# Test 1: Redis Caching and Pub/Sub Demo

## Simple Explanation
Spring Boot talks to Redis via Lettuce. The application writes a `Profile` object into Redis with TTL, caches it for faster reads, and publishes the same payload on `profile-notifications` so any subscriber (even a CLI `redis-cli`) can react.

## Flow
1. `ProfileController` accepts POST/GET. POST uses `ProfileService` to store the payload via `RedisTemplate.opsForValue()` and sets TTL for 1 hour. GET attempts to read from Redis and falls back to a stub (simulating a more expensive downstream) when the key is missing.
2. `RedisConfig` configures `RedisConnectionFactory`, `RedisTemplate`, and a `MessageListenerAdapter` that logs every message published on `profile-notifications` – this mimics a simple event listener.
3. The service publishes the profile JSON on `profile-notifications` using `RedisTemplate.convertAndSend` so subscribers can act on updates.

## Outcome
After this test you can configure Spring Boot + Redis, cache domain objects with TTL, publish notifications, and register a listener to verify the subscriptions work.
