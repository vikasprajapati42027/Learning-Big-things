# Test 20: JWT (Stateless Security)

Sessions are hard to scale in microservices. JWT solves this.

## What is a JWT?
A string composed of three parts:
1. **Header**: Type of token and hashing algorithm.
2. **Payload**: Data about the user (Claims).
3. **Signature**: Used to verify that the sender is who they say they are.

## Pros:
- **Stateless**: The server doesn't need to store session data in memory.
- **Scalable**: Works perfectly with multiple servers.

## Cons:
- **Revocation**: Hard to invalidate a token before it expires.
- **Size**: Can get large if you put too much data in it.
