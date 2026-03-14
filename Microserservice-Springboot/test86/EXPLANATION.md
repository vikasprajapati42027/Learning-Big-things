# Test 86: WebSockets (Real-Time Chat)

Full-duplex communication — both sides can send data at any time.

## Key Files:
- `ChatController.java`: STOMP-based WebSocket config and message handler.
- `EXPLANATION.md`: WebSocket vs SSE vs HTTP Polling.

## Concept:
HTTP is "knock and answer." WebSocket is a persistent, open phone line. Either side can speak at any time. Perfect for chat, live collaboration tools (like Google Docs), and multiplayer games where milliseconds matter.
