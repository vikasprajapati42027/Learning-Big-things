# Test 7: Dead Letter Queue (DLQ) Pattern

## Why DLQ?
When a consumer fails to process a message (bad data format, service down),
you don't want to lose it OR block the main queue forever.

## Flow
```
Main Queue → Consumer fails 3x → Dead Letter Queue
                                       ↓
                                  Operator investigates
                                  Fix the bug
                                  Replay the message
```

## RabbitMQ DLQ Setup
```java
@Bean
Queue mainQueue() {
    return QueueBuilder.durable("orders")
        .withArgument("x-dead-letter-exchange", "dlx")  // Where fallen msgs go
        .withArgument("x-message-ttl", 30000)           // 30s timeout
        .build();
}

@Bean
Queue deadLetterQueue() { return new Queue("orders-dlq", true); }
```

## Kafka DLQ (Dead Letter Topic)
```java
@RetryableTopic(
    attempts = "3",
    dltTopicSuffix = "-dlq"           // Failed msgs → orders-dlq topic
)
@KafkaListener(topics = "orders")
void processOrder(String message) { ... }
```
