# Test 43: RSocket (Reactive Streams)

Beyond HTTP: Bidirectional communication.

## The Old Way (HTTP):
The Client asks, the Server answers. If the Server wants to send an update, it can't.

## The New Way (RSocket):
Once the connection is open, the **Server can push data to the Client** without being asked.
- **Fire-and-Forget**: Send data and don't wait for answer.
- **Request-Stream**: Ask once, get a constant stream of updates (like live stock prices).

It's built for **Cloud-Native Reactive Applications**.
