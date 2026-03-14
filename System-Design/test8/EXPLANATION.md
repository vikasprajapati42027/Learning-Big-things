# Test 8: Design a Chat Application (WhatsApp)

## Core Requirements
- One-to-One messaging
- Group chats (up to 500 members)
- Message delivery status: Sent → Delivered → Read
- Offline message delivery

## Key Technology Choices
| Component | Choice | Why |
|-----------|--------|-----|
| Real-time | WebSocket | Persistent two-way connection |
| Storage | Cassandra | Write-heavy, high availability |
| Media | AWS S3 | Scalable object storage |
| Auth | JWT | Stateless auth for microservices |

## Message Flow
```
Vikas types "Hello" → WebSocket → Chat Server
                                      ↓
                              Kafka: "message_events"
                                      ↓
                        ┌─────────── Message Service ───────────┐
                        │                                        │
                   Save to Cassandra              Deliver to Rahul's WebSocket
                                                  (if online) or push notification
```

## Cassandra Schema (Optimized for "Load my chat history")
```sql
CREATE TABLE messages (
    chat_id  UUID,
    msg_id   TIMEUUID,   -- Sorted by time automatically
    sender   TEXT,
    content  TEXT,
    PRIMARY KEY (chat_id, msg_id)
) WITH CLUSTERING ORDER BY (msg_id DESC);
```

## Delivery Status
- **Sent** (✓): Saved to Cassandra
- **Delivered** (✓✓): Delivered to recipient's device
- **Read** (✓✓ blue): Recipient opened the chat
