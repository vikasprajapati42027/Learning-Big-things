# Chat Microservices (test6)

WhatsApp-style real-time messaging using Spring Boot 3.2.x, WebSockets (STOMP), and Kafka for durable fan-out.

Modules
- common: shared events, Kafka topic constants + auto-creation
- gateway-service (port 8200): WebSocket/STOMP endpoint `/ws`, publishes chat/presence events to Kafka, echoes to subscribers
- message-service (port 8201): consumes `chat.messages`, stores history, REST `GET /history/{roomId}`
- presence-service (port 8202): consumes `presence.events`, stores online/offline status, REST `GET /presence/{username}`

Prerequisites
- Java 17, Maven 3.9+
- Docker (Kafka + Zookeeper) or Kafka at localhost:9092

Run locally
```bash
cd java-backend-project/test6

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
mvn -pl gateway-service spring-boot:run
mvn -pl message-service spring-boot:run
mvn -pl presence-service spring-boot:run
```

WebSocket usage (STOMP)
- Connect to `ws://localhost:8200/ws` (SockJS allowed).
- Subscribe to `/topic/messages` for chat and `/topic/presence` for status.
- Send chat: destination `/app/chat.send`, payload `{ "roomId":"general", "fromUser":"alice", "content":"hi", "timestamp":1700000000000 }`
- Send presence: destination `/app/presence.update`, payload `{ "user":"alice", "status":"ONLINE", "timestamp":1700000000000 }`

REST checks
```bash
# chat history
curl http://localhost:8201/history/general
# presence
curl http://localhost:8202/presence/alice
```

Notes
- H2 in-memory stores for messages/presence; data resets on restart.
- Simple in-broker STOMP for live fan-out; Kafka provides durability and cross-service decoupling.
