# Test 10: Security Audit Logging

## Simple Explanation
Every login attempt (success or failure) should be recorded.
Why? To detect attacks and meet compliance requirements (GDPR, PCI-DSS).

## Spring Security Events
Spring automatically publishes events when authentication succeeds or fails.
You just listen for them — zero extra code needed in your controller!

## What to log in production:
```
[2026-03-14 13:40] SUCCESS  | user: vikas@mail.com | IP: 192.168.1.1 | Device: Chrome/Linux
[2026-03-14 13:41] FAILURE  | user: admin        | IP: 1.2.3.4      | Reason: Bad password
[2026-03-14 13:41] LOCKED   | user: admin        | IP: 1.2.3.4      | 5 consecutive failures
```

## Other Useful Events
| Event | When |
|-------|------|
| `AuthenticationSuccessEvent` | Successful login |
| `BadCredentialsEvent` | Wrong password |
| `AuthorizationDeniedEvent` | Access to forbidden URL |
| `SessionFixationProtectionEvent` | Session hijack attempt detected |
