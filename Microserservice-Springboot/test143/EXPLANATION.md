# Test 143: Servlet Filters & MDC Logging

Injecting context (like a Request ID) into every log line automatically.

## Key Files:
- `RequestIdFilter.java`: A Servlet Filter that reads `X-Request-ID` and adds it to the MDC.
- `EXPLANATION.md`: MDC (Mapped Diagnostic Context) for contextual logging.

## Concept:
With MDC, you configure your logger to include `requestId` in every log line. Now when you search logs for "Request #abc-123", you see every log message from that single HTTP request — across multiple service calls — all tagged with the same ID.
