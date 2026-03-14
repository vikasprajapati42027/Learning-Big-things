# Test 3: Kafka Topics, Partitions & Consumer Groups

## Topic = Category of Messages
```
"order-events"   → All order-related messages
"payment-events" → All payment messages
"user-events"    → All user activity messages
```

## Partitions = Parallelism
```
Topic: order-events (3 partitions)
Partition 0: [msg1][msg4][msg7]...
Partition 1: [msg2][msg5][msg8]...
Partition 2: [msg3][msg6][msg9]...
```
More partitions = more consumers working in parallel = higher throughput.

## Message Ordering
Messages with the SAME key go to the SAME partition → ordered within a key.
```java
kafkaTemplate.send("orders", "user-123", message); // All user-123 messages are ordered!
```

## Replication Factor
```yaml
num.partitions: 3
replication.factor: 3  # Each partition has 3 copies on 3 different brokers
```
If 2 brokers crash, your data still exists on the third!
