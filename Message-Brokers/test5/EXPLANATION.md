# Test 5: Message Acknowledgement & Durability

## Delivery Guarantees
| Guarantee | What it means | Risk |
|-----------|---------------|------|
| **At-most-once** | Message sent, may or may not be received | Data loss possible |
| **At-least-once** | Message eventually received, may be duplicated | Need idempotency |
| **Exactly-once** | Perfect delivery (hardest, most expensive) | Kafka transactions |

## Acknowledgement in RabbitMQ
```java
channel.basicAck(deliveryTag, false);   // "I processed this — remove from queue"
channel.basicNack(deliveryTag, false, true); // "Failed — put back / send to DLQ"
```

## Making Consumers Idempotent
Since at-least-once can duplicate, design consumers to handle duplicates:
```java
if (alreadyProcessed(messageId)) return; // Skip duplicate
process(message);
markAsProcessed(messageId);              // Record in DB
```

## Durable Queues
```java
channel.queueDeclare("orders", true, false, false, null);
//                               ↑ durable = queue survives RabbitMQ restart
```
