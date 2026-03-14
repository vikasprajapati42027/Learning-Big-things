# Test 2: Kafka Consumer

## Simple Explanation
A Kafka Consumer reads messages from a topic and processes them.
Multiple consumers in the same `groupId` share the work (each gets different partitions).

## Consumer Group
```
Topic: order-events (3 partitions)
                 
Consumer Group: "order-processor"
  Consumer 1 → Partition 0
  Consumer 2 → Partition 1  
  Consumer 3 → Partition 2
```
Adding more consumers = more parallelism (up to max = number of partitions).

## Offsets — Tracking Progress
```
Partition 0: [msg1] [msg2] [msg3] [msg4] [msg5]
                                    ↑ offset=3 (consumer has processed up to here)
```
After processing: consumer commits offset 4 → "I'm done with msg4"
On restart: consumer continues from offset 4 (doesn't reprocess!)

## @RetryableTopic — Automatic Retry
```
Process fails → Retry on topic: payment-events-retry-1 (after 1s)
Still fails   → Retry on topic: payment-events-retry-2 (after 2s)
Still fails   → Send to DLT:   payment-events-dlt (manual review)
```

## application.properties
```properties
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.enable-auto-commit=false
```
