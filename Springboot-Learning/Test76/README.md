# Test 76: Spring Session

Solve the "Sticky Session" problem.

## The Problem:
If you have 2 servers and a user logs into Server 1, their session is in Server 1's RAM. If their next request goes to Server 2, they are suddenly logged out!

## The Solution:
Store the Session in a shared database.
- Server 1 saves session to Redis.
- Server 2 reads session from Redis.
The user never knows the difference, and you can restart servers safely without logging everyone out!
