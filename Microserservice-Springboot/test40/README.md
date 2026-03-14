# Test 40: Distributed Locking (Redis)

Preventing two services from doing the same thing.

## The Problem:
You have 10 instances of the `EmailService`. Two instances might pick up the same "Welcome Email" task at the exact same millisecond and send the user TWO emails. Embarrassing!

## The Solution:
Use Redis to create a "Lock".
1. Service A says to Redis: "I am locking the key `EMAIL_FOR_VIKAS` for 10 seconds."
2. Service B tries to lock the same key. Redis says "NO, it's already locked."
3. Service B waits or skips.
4. Service A finishes and releases the lock.

This ensures **Exclusive Access** in a distributed world.
