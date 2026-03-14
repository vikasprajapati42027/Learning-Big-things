# Test 9: Brute Force Attack Protection

## What is a Brute Force Attack?
An attacker tries thousands of passwords automatically until finding the right one.
Without protection: 1 million passwords/hour is possible!

## Solution: Login Attempt Limiting
After 5 failed attempts → Lock the account for 30 minutes.

## Implementation Options
| Option | Storage | Works with |
|--------|---------|-----------|
| In-memory Map | RAM | Single server only |
| Redis Counter | Redis DB | Multiple servers ✅ |
| DB flag | Database | Persistent but slow |

## Production with Redis
```java
redisTemplate.opsForValue().increment("login_fails:" + username);
redisTemplate.expire("login_fails:" + username, 30, TimeUnit.MINUTES);
```

## Additional Security Layers
- **CAPTCHA** after 3 failed attempts
- **Email notification** "Someone is trying to login to your account"
- **IP-based blocking** for automated scripts
