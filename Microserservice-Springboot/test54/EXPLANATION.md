# Test 54: Spring WebFlux (Reactive Programming)

Building non-blocking, asynchronous web applications.

## Concepts:
- **Mono**: A stream that emits 0 or 1 item.
- **Flux**: A stream that emits 0 to N items over time.
- **Backpressure**: The ability for the consumer to tell the producer "Slow down, I can't handle this much data yet."

## Why WebFlux?
Standard Web MVC uses One-Thread-Per-Request. If 1000 requests are waiting for a slow DB, 1000 threads are blocked. WebFlux uses just a few threads (event loop) to handle thousands of concurrent requests by never waiting.
