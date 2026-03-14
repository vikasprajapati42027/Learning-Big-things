# Test 12: Kafka Exactly-Once (Idempotence)

## Simple Explanation
In a distributed system, a Producer might send a message, but the Network fails during the ACKnowledge step. The Producer thinks it failed and SENDS AGAIN. 
Result: Duplicate messages in Kafka.

**Idempotent Producer** prevents this!

## How it works
Kafka assigns a **Producer ID** and a **Sequence Number** to every message.
1. Message (PID=1, Seq=0) → Saved in Kafka.
2. ACK fails → Network error.
3. Producer sends Message (PID=1, Seq=0) AGAIN.
4. Kafka sees (PID=1, Seq=0) is already there → Drops duplicate but sends ACK back!

## How to enable
In modern Spring Boot / Kafka (3.0+), it is **ON BY DEFAULT**.
Manually: `props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");`

## Limitation
This only works within a single Producer session and for a single partition. For cross-partition atomicity, you need **Transactions**.
