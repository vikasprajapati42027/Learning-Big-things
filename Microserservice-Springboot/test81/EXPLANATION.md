# Test 81: OpenFeign with Fallback

Declarative HTTP calls with built-in resilience.

## Key Files:
- `UserClient.java`: Shows how to define an interface for calling other services and a fallback class.
- `EXPLANATION.md`: Why you should never call a service without a fallback.

## Why use it?
It's much cleaner than RestTemplate. You just write an interface, and Spring generates the code. If the remote service fails, the `fallback` class kicks in immediately, so your app doesn't crash.
