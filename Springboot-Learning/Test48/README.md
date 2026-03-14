# Test 48: Distributed Tracing

Debug a request through the whole system.

## The Problem:
An error occurs in `Shipping-Service`. But that service was called by `Order-Service`, which was called by the `API-Gateway`. How do you find the logs for that SPECIFIC user request across 3 different servers?

## The Solution:
- **Trace ID**: Unique ID for one end-to-end request.
- **Span ID**: Unique ID for one hop (one service call).

Using tools like **Zipkin**, you can see a visual timeline of how long each service took.
