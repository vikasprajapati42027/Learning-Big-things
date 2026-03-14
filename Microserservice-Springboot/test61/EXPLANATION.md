# Test 61: Distributed Tracing (Header Propagation)

How Trace IDs "travel" between services.

## Key Files:
- `PropagatorController.java`: Shows how headers like `X-B3-TraceId` are passed along.
- `EXPLANATION.md`: Understanding the B3 Propagation format.

## Concept:
When Service A calls Service B, Sleuth injects a unique ID into the HTTP header. Service B reads this ID and includes it in its own logs. This "traveling ID" allows you to trace a single user request across 50 different microservices!
