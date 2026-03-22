# E-Commerce Microservices (User, Product, Order, Payment)

Small Spring Boot 3.2.x, Java 17, Maven multi‑module demo with Kafka‑based event flow:
- `orders.created` event from Order → Payment consumes, records payment, emits `payments.completed`
- Order consumes `payments.completed` to update status

## Prerequisites
- Java 17+
- Maven 3.9+
- Docker (for local Kafka/ZooKeeper)

## Quick start
```bash
cd java-backend-project/test2

# 1) Start Kafka locally (single broker)
docker run -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper
docker run -d --name kafka -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT \
  -e KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  --link zookeeper wurstmeister/kafka

# 2) Build shared module once
mvn -pl common install

# 3) Run each service in separate terminals
mvn -pl user-service spring-boot:run      # port 8081
mvn -pl product-service spring-boot:run   # port 8082
mvn -pl order-service spring-boot:run     # port 8083
mvn -pl payment-service spring-boot:run   # port 8084
```

## Smoke test flow (curl)
```bash
# create user
curl -X POST http://localhost:8081/users -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@example.com"}'

# create product
curl -X POST http://localhost:8082/products -H "Content-Type: application/json" \
  -d '{"name":"Book","description":"Design Patterns","price":25.00,"stock":10}'

# place order (triggers events)
curl -X POST http://localhost:8083/orders -H "Content-Type: application/json" \
  -d '{"userId":1,"productId":1,"quantity":2,"amount":50.00}'

# check payments and order status
curl http://localhost:8084/payments
curl http://localhost:8083/orders
```

## Notes
- H2 in‑memory DBs; data resets on restart.
- Kafka topics auto-created by `common` module config.
- Adjust ports in each service `application.yml` if needed.
