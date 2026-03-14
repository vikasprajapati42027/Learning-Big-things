# Test 116: Graceful Shutdown

Finishing active requests before the server turns off.

## Key Files:
- `ShutdownApplication.java`: Main app.
- `application.properties`: Configuration for graceful period.
- `EXPLANATION.md`: Why hard-killing a server causes data loss.

## Why use it?
Without Graceful Shutdown, if you stop the server during a payment, that payment might be lost forever. With this feature, the server says, "I'm stopping, so no more new requests, but I'll finish the ones I've already started before I leave."
