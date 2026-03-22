# API Rate Limiter (Token Bucket + Sliding Window)

Spring Boot 3.2.x demo showcasing two Redis-backed algorithms:
- Token bucket (steady refill, bursty allowance)
- Sliding window counter (per-minute cap)

## Prerequisites
- Java 17, Maven 3.9+
- Redis running locally on 6379 (e.g., `docker run -d --name redis -p 6379:6379 redis:7`)

## Run
```bash
cd java-backend-project/test7
mvn spring-boot:run
```
App starts on port 8300.

## Endpoints
- `GET /api/hello` — guarded by token bucket (5 rps, burst 10)
- `GET /api/search` — guarded by sliding window (20 requests / 60s)

## How it works
- Token bucket: Lua script in Redis tracks tokens + last refill, ensures atomicity.
- Sliding window: sorted-set per key; old timestamps evicted before counting.
- Keys use client IP by default; swap to user ID / API key as needed.

## Tuning
Adjust limits in `DemoController` or externalize via config env vars for prod.
