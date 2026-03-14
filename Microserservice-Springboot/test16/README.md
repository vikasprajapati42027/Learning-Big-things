# Test 16: Apache Kafka (Big Data Streams)

Reliability at scale.

## Kafka vs RabbitMQ:
- **RabbitMQ**: Once a message is consumed, it's gone.
- **Kafka**: Messages are stored like an "Audit Log". If a second service joins later, it can "Replay" old messages from 3 days ago!

## Why use it?
It's perfect for complex systems where many different services need the same data (Logs, Stock Prices, User Clicks) at different times.
