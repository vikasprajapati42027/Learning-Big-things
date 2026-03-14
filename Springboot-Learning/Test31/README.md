# Test 31: Custom Error Model

Don't let your API leak internal stack traces.

## Best Practice:
Always return a consistent JSON structure for errors. This helps frontend developers catch and display user-friendly messages.

## Fields to include:
- `status`: HTTP status code (numeric).
- `message`: Human-readable explanation.
- `timestamp`: When the error occurred.
- `path`: (Optional) The URL being accessed.
- `traceId`: (Optional) For searching in logs.
