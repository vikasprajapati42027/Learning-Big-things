# Test 127: Spring Retry (@Retryable)

Automatically re-trying failed operations with configurable backoff.

## Key Files:
- `RetryService.java`: Shows `@Retryable` (3 attempts, 1 second delay) and `@Recover` (the fallback).
- `EXPLANATION.md`: Exponential backoff and why it's crucial for distributed systems.

## Concept:
Network blips and temporary service unavailability happen constantly in distributed systems. Instead of failing immediately, `@Retryable` automatically tries again after a delay. The `@Recover` method handles the case where ALL retries are exhausted.
