# Test 15: Event-Driven Architecture (RabbitMQ)

Unblocking your microservices.

## Sync vs Async:
- **Synchronous (REST)**: Like a phone call. If the other person doesn't pick up, you wait or get an error.
- **Asynchronous (RabbitMQ)**: Like an Email. You send the message. The other service picks it up when it's ready.

## Use Case:
When an Order is placed:
1. Save order to DB.
2. Send message to `order_queue`.
3. The "Email Service" hears the message and sends the confirmation.
4. The "Inventory Service" hears the message and prepares the box.
The user doesn't have to wait for the email or inventory check to finish!
