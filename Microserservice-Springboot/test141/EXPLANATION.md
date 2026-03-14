# Test 141: Server-Side Events (SSE)

Real-time "Push" notifications from server to browser.

## Key Files:
- `SseController.java`: Demonstrates using `Flux` to stream events to a browser.
- `EXPLANATION.md`: SSE vs WebSockets.

## Concept:
Unlike standard APIs where the browser must ask for data, SSE allows the server to keep a "pipe" open. Whenever something changes (like a stock price or a new message), the server "pushes" the update to the client instantly. It's simpler and more efficient than WebSockets for one-way updates.
