# Test 2: JWT (JSON Web Tokens)

## Simple Explanation
Instead of storing a session on the server, you give the client a "Badge" (JWT token).
The client sends this badge with every request. The server reads the badge and trusts it.

## JWT Structure (3 parts separated by dots)
```
eyJhbGciOi... . eyJ1c2VybmFtZ... . SflKxw... 
  HEADER        PAYLOAD            SIGNATURE
```
- **Header**: Algorithm used (e.g., HS256)
- **Payload**: Data (username, role, expiry)
- **Signature**: Proves the token wasn't tampered with

## JWT Flow
```
POST /login (username + password)
    ↓
Server verifies, creates JWT, sends it back
    ↓
Client stores JWT (localStorage or cookie)
    ↓
Every request: Authorization: Bearer <jwt-token>
    ↓
Server reads token, verifies signature, extracts username → Serves request
```

## Why Stateless?
No session stored on server! Any of your 100 servers can verify the token because they
all share the same secret key. Perfect for microservices and scaling.
