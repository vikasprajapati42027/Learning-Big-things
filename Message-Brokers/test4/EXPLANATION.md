# Test 4: RabbitMQ — Exchange Types

## How RabbitMQ Works
```
Producer → Exchange → Queue → Consumer
```
The Exchange is the "router" that decides which queue gets the message.

## 4 Exchange Types
| Type | Routing Logic | Use Case |
|------|---------------|---------|
| **Direct** | Route by exact key | Order processing by region |
| **Fanout** | Send to ALL queues | Logging to multiple systems |
| **Topic** | Route by pattern (*.error, orders.#) | Microservice event routing |
| **Headers** | Route by message headers | Complex content-based routing |

## Fanout Pattern (Pub/Sub)
```java
@Bean
FanoutExchange fanout() { return new FanoutExchange("notifications"); }

// ALL queues bound to this exchange receive the message
// Email Queue, SMS Queue, Push Queue all get it simultaneously!
```

## Topic Pattern
```
"orders.india.electronics" matches:
- "orders.*.*" (any 2 trailing words)
- "orders.#"   (any number of trailing words, # is wildcard)
- "#"          (matches everything)
```
