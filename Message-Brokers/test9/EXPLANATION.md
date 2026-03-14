# Test 9: Message Ordering & Idempotency

## Ordering Challenges
- Kafka: Ordering guaranteed only WITHIN a partition (not across)
- SQS Standard: No ordering guarantee at all!
- SQS FIFO: Strict ordering, but max 300 msg/sec

## Kafka Message Key for Ordering
```java
// All messages for order-123 go to the same partition → ordered!
kafkaTemplate.send("orders", "order-123", message);
```

## The Idempotency Problem
At-least-once delivery = same message might arrive TWICE!
```
Network timeout → Producer retries → Duplicate!
```

## Solution: Idempotency Key
```java
void process(OrderEvent event) {
    if (processedIds.contains(event.getMessageId())) {
        log.info("Duplicate detected, skipping: " + event.getMessageId());
        return;
    }
    // Process normally
    doWork(event);
    processedIds.add(event.getMessageId()); // Mark in Redis with TTL
}
```

## Kafka Exactly-Once (Idempotent Producer)
```properties
spring.kafka.producer.properties.enable.idempotence=true
spring.kafka.producer.properties.transactional.id=my-transactional-id
```
