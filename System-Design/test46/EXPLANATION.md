# Test 46: Designing a Social Media Feed (System Design)

## 1. Requirement
Load the latest posts from 500 friends in under 200ms for 100 million active users.

## 2. The Pull Model (Fan-out on Read)
When the user opens the app, the server finds all friends, gets their latest posts, and sorts them.
- **Pros**: Simple to scale writes.
- **Cons**: Extremely slow for users with 5,000 friends (too much sorting on every click).

## 3. The Push Model (Fan-out on Write)
When a user posts something, the server instantly "pushes" that post into the `Pre-computed Feed` of all their 500 friends.
- **Pros**: Fast reads! The user's feed is already ready in **Redis**.
- **Cons**: Broken for "Celebrities". If Justin Bieber posts, pushing to 100 million fans will crash the system (Fan-out overload).

## 4. The Hybrid Approach (The Industry Standard)
- **Regular Users**: Use the **Push Model**. It's fast and efficient.
- **Celebrities**: Do NOT push their posts. Instead, when a fan opens their feed, the server **Pulls** only the celebrity's latest post and injects it into the precomputed feed.

## 5. Storage
- **Metadata (User/Post)**: SQL (Postgres).
- **The Feed**: Redis (List or ZSET). 
- **Media**: S3 + CDN.
