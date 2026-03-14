# Test 112: Rate Limiting (Bucket4j)

Protecting your servers from API abuse.

## Key Files:
- `RateLimitController.java`: Demonstrates the "Token Bucket" algorithm.
- `EXPLANATION.md`: Why rate limiting is your first line of defense.

## Concept:
Bucket4j provides virtual "Tokens". Every request takes 1 token. When the bucket is empty, requests are rejected until the bucket refills automatically. This prevents a single user from crashing your system with 1,000 requests per second.
