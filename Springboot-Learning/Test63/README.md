# Test 63: RSocket (Reactive Protocol)

The protocol designed for Reactive microservices.

## Interactions:
1. **Request-Response**: Like HTTP.
2. **Fire-and-Forget**: Send and don't care about the result.
3. **Request-Stream**: Send one, get many back.
4. **Channel**: Two-way streaming.

## Feature: Backpressure
If the client is slow, it can tell the server "Wait, stop sending data for a second!". This prevents the client from crashing due to data overflow.
