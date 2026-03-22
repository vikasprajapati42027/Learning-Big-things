# Social Media Backend (test13)

Spring Boot 3.2.x, Java 17 demo for Twitter-like backend: users, follows, posting, cached news feed.

## Features
- Create users
- Follow / unfollow
- Create posts (280 chars)
- Fetch news feed (self + followees, newest first) with Caffeine cache and eviction on writes/follows
- H2 in-memory DB

## Prerequisites
- Java 17, Maven 3.9+

## Run
```bash
cd java-backend-project/test13
mvn spring-boot:run
```
Service on `http://localhost:8900`.

## API
- `POST /users` — `{ "handle":"alice", "name":"Alice" }`
- `GET /users`
- `POST /follows` — `{ "followerId":1, "followeeId":2 }`
- `DELETE /follows?followerId=1&followeeId=2`
- `POST /posts` — `{ "userId":1, "content":"hello world" }`
- `GET /feed/{userId}` — aggregated feed for user (cached 30s)

## Notes
- Optimistic feed caching: cache cleared on new post or follow/unfollow for that user.
- Extend by adding pagination, media, likes, and storing feeds in Redis for horizontal scale.
