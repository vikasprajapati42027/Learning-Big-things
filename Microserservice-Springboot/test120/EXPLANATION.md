# Test 120: Aspect-Oriented Programming (AOP)

Adding cross-cutting concerns (logging, timing) without touching business code.

## Key Files:
- `PerformanceAspect.java`: An `@Around` aspect with a custom `@TrackTime` annotation.
- `EXPLANATION.md`: AOP for clean separation of concerns.

## Concept:
Add `@TrackTime` above any method and the AOP aspect automatically wraps it — recording how long it takes. No if-statements in the business code. You can add this to 100 methods without changing a single line of their logic.
