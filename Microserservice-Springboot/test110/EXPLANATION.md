# Test 110: OpenTelemetry (Otel)

The industry standard for distributed tracing and metrics.

## Key Files:
- `OtelService.java`: Shows the `@WithSpan` annotation for manual tracing.
- `EXPLANATION.md`: Why Otel replaces Sleuth in Spring Boot 3.

## Concept:
OpenTelemetry is a vendor-neutral standard. You instrument your code once, and you can send the data to Jaeger, Zipkin, Honeycomb, or AWS X-Ray without changing a single line of your Java code.
