# Test 6: Kafka Streams — Real-Time Processing

## Simple Explanation
Kafka Streams processes messages as they flow through Kafka in real-time.
No batch jobs — results are computed instantly as new data arrives.

## Use Cases
- Real-time fraud detection (process each transaction as it happens)
- Live analytics dashboard
- Joining two event streams (user activity + product views)

## DSL Example
```java
StreamsBuilder builder = new StreamsBuilder();
KStream<String, String> orders = builder.stream("orders");

// Filter only high-value orders
KStream<String, String> bigOrders = orders
    .filter((key, value) -> extractAmount(value) > 10000);

// Count orders per category (5-minute window)
bigOrders
    .groupByKey()
    .windowedBy(TimeWindows.of(Duration.ofMinutes(5)))
    .count()
    .toStream()
    .to("order-counts");
```

## Kafka Streams vs Kafka Consumer
| | Kafka Consumer | Kafka Streams |
|-|---------------|---------------|
| Use case | Simple message processing | Complex transformations, joins, aggregations |
| State | Stateless | Stateful (windowing, aggregations) |
| Complexity | Simple | More complex but powerful |
