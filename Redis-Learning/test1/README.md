# Test 1: Redis Caching + PubSub with Spring Boot

## Overview
Build a Maven-powered Spring Boot service that leverages Redis for both caching domain data and publishing simple events. You will see how to configure `RedisTemplate`, cache a profile, and publish a change notification while reading/writing the data via REST.

## Learning Goals
1. Understand how to wire Spring Data Redis (`spring-boot-starter-data-redis`) with Lettuce.
2. Use `RedisTemplate` for CRUD and caching semantics plus TTL.
3. Publish simple change notifications to `profile-notifications` using `RedisTemplate.convertAndSend`.
4. Read from Redis Pub/Sub using a `MessageListenerAdapter`.

## Run instructions
```bash
mvn clean package
mvn spring-boot:run
```

## Try it out
Write a profile (stored in Redis with a 1-hour TTL):
```bash
curl -X POST http://localhost:8090/profiles \
  -H "Content-Type: application/json" \
  -d '{"id":"user-11","name":"Ada Lovelace","email":"ada@example.com"}'
```

Read it back (cached):
```bash
curl http://localhost:8090/profiles/user-11
```

Watch Redis Pub/Sub messages:
```bash
redis-cli subscribe profile-notifications
```

the service logs show each publish along with the subscriber printing the payload to the console.
