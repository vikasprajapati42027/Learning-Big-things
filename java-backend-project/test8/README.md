# Notification Service (email / sms / push)

Spring Boot 3.2.x, Java 17, event-driven notifications using Kafka.

Modules
- common: shared NotificationEvent, topic constant, topic auto-creation
- notification-service (port 8400): REST `/notify` → publishes to Kafka; consumer logs simulated email/SMS/push sends

Prerequisites
- Java 17, Maven 3.9+
- Kafka (localhost:9092) + Zookeeper; easiest via Docker:
```bash
docker run -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper
docker run -d --name kafka -p 9092:9092 --link zookeeper \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT \
  -e KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  wurstmeister/kafka
```

Run
```bash
cd java-backend-project/test8
mvn -pl common install
mvn -pl notification-service spring-boot:run
```

Test
```bash
curl -X POST http://localhost:8400/notify -H 'Content-Type: application/json' \
  -d '{"userId":"u1","channel":"EMAIL","template":"welcome","data":{"name":"Alice"}}'
```
Check service logs to see simulated email/SMS/push output.

Notes
- Message sending is mocked (logs); swap NotificationSender methods to integrate real SMTP/SMS/push providers.
- Topics auto-created when Kafka reachable.
