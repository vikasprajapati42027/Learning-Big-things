# Test 59: RSocket (Fire-and-Forget)

Sending data without caring about the response.

## Key Files:
- `FireAndForgetController.java`: Logic for handling incoming events without returning a value.
- `EXPLANATION.md`: Use cases like telemetry, logging, and notifications.

## Why use it?
It's much faster because the client doesn't wait for the server to say "I got it." Best for data that isn't mission-critical if one or two messages are lost.
