# Food Delivery Microservices (Swiggy/Zomato style)

Spring Boot 3.2.x, Java 17, Maven multi-module demo with restaurant listing, order placement, and delivery tracking via Kafka events.

Modules
- common: shared events, topic constants, Kafka topic auto-creation
- restaurant-service: CRUD restaurants
- order-service: places orders, emits `orders.placed`, updates status from delivery events
- delivery-service: listens to `orders.placed`, assigns driver, emits `delivery.status`

Prerequisites
- Java 17, Maven 3.9+
- Docker (for Kafka + ZK) or a running Kafka broker on localhost:9092

Run locally
```bash
cd java-backend-project/test3

# Start Kafka + Zookeeper
docker run -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper
docker run -d --name kafka -p 9092:9092 --link zookeeper \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT \
  -e KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  wurstmeister/kafka

# Build shared module
mvn -pl common install

# Run services (separate terminals)
mvn -pl restaurant-service spring-boot:run   # port 8091
mvn -pl order-service spring-boot:run        # port 8092
mvn -pl delivery-service spring-boot:run     # port 8093
```

Quick test
```bash
# create restaurant
curl -X POST http://localhost:8091/restaurants -H 'Content-Type: application/json' \
  -d '{"name":"Tasty Biryani","cuisine":"Indian","address":"MG Road"}'

# place order (restaurantId=1, userId=42)
curl -X POST http://localhost:8092/orders -H 'Content-Type: application/json' \
  -d '{"restaurantId":1,"userId":42,"items":"biryani,raita","totalAmount":15.50,"address":"Brigade Rd"}'

# check delivery assignments
curl http://localhost:8093/deliveries

# simulate status update
curl -X POST "http://localhost:8093/deliveries/1/status?status=OUT_FOR_DELIVERY"

# confirm order status updated via event
curl http://localhost:8092/orders
```

Notes
- H2 in-memory DBs; data resets on restart.
- Topics auto-created by `common` when Kafka is reachable.
- Simplified payloads (comma-separated items) to keep focus on messaging flow.
