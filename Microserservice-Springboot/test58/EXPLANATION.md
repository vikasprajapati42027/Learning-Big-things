# Test 58: Reactive Caching

Combining Redis or In-Memory caching with non-blocking streams.

## Key Files:
- `ReactiveCacheService.java`: Logic for non-blocking cache lookups.
- `EXPLANATION.md`: Why you shouldn't use blocking caches in a reactive app.

## Concept:
In a reactive application, every step must be non-blocking. If your "Cache Check" blocks a thread, you lose all the performance benefits of WebFlux. This module shows how to keep the flow asynchronous.
