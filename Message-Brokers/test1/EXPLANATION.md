# Test 1: Kafka Producer

## Simple Explanation
A Kafka Producer sends messages (events) to a Kafka Topic.
Consumers then read messages from that topic.

## Key Concepts
| Concept | Meaning |
|---------|---------|
| **Topic** | A named channel where messages are published |
| **Partition** | A topic is split into partitions for parallelism |
| **Message Key** | Same key → same partition → guaranteed ordering |
| **Offset** | Position of a message in a partition |

## Why Kafka?
- **Async**: Producer doesn't wait for consumer
- **Durable**: Messages are stored on disk (survives restart)
- **Scalable**: Consumers can work in parallel across partitions
- **Replayable**: Read old messages again from any offset

## application.properties
```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
```
