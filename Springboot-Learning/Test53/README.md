# Test 53: Spring Integration

The Enterprise Service Bus (ESB) for Spring.

## Goal:
To provide a way to integrate disparate systems (Legacy DB, Modern API, FTP Server, Email) using a standard messaging approach.

## Key Patterns:
- **Adapter**: Converts system-specific data to a Spring Message.
- **Pipe and Filter**: Messages go through a series of steps (Log -> Clean -> Save).
- **Splitter**: Breaks a large message into small ones.
- **Aggregator**: Combines multiple messages into one.
