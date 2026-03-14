# Test 10: Choosing the Right Message Broker

## Kafka vs RabbitMQ vs SQS

| Feature | Kafka | RabbitMQ | AWS SQS |
|---------|-------|---------|---------|
| **Type** | Log / Event Stream | Traditional MQ | Managed MQ |
| **Persistence** | Messages stored for days | Until consumed | 14 days max |
| **Ordering** | Per partition | Per queue | FIFO only (SQS FIFO) |
| **Replay** | Yes — read from any offset | No | No |
| **Throughput** | Very high (millions/sec) | High (100K/sec) | Medium |
| **Setup** | Complex | Moderate | Zero (AWS managed) |
| **Best for** | Event sourcing, analytics, streaming | Task queues, workflows | AWS ecosystem |

## When to Use What

### Pick Kafka when:
- You need event replay (audit, re-processing)
- Very high throughput needed
- Multiple independent consumers reading same events

### Pick RabbitMQ when:
- Complex routing (topic/fanout exchanges)
- Work queues with priorities
- Self-hosted required (on-premise)

### Pick AWS SQS when:
- Already on AWS
- Want zero maintenance overhead
- Simple queue usage
