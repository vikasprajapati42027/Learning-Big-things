# Ride Booking Microservices (Uber-like)

Spring Boot 3.2.x, Java 17, Maven multi-module system with event-driven ride flow: booking → dispatch → tracking.

Modules
- common: shared events, topic constants, Kafka topic auto-creation
- rider-service: manage riders
- driver-service: manage drivers (availability stored, not yet integrated to dispatch)
- booking-service: accept ride requests, emit `ride.requested`
- dispatch-service: listens `ride.requested`, assigns mock driver, emits `ride.assigned`
- tracking-service: listens `ride.assigned`, stores status, re-broadcasts `ride.status`; REST to update/read status

Prerequisites
- Java 17, Maven 3.9+
- Docker (Kafka+ZK) or Kafka at localhost:9092

Run locally
```bash
cd java-backend-project/test4

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
mvn -pl rider-service spring-boot:run      # 8101
mvn -pl driver-service spring-boot:run     # 8102
mvn -pl booking-service spring-boot:run    # 8103
mvn -pl dispatch-service spring-boot:run   # 8104
mvn -pl tracking-service spring-boot:run   # 8105
```

Quick test
```bash
# add rider
curl -X POST http://localhost:8101/riders -H 'Content-Type: application/json' \
  -d '{"name":"Alice","phone":"99999"}'

# request ride
curl -X POST http://localhost:8103/rides -H 'Content-Type: application/json' \
  -d '{"riderId":1,"pickup":"Downtown","dropoff":"Airport"}'

# check tracking (after dispatch and status event)
curl http://localhost:8105/tracking/1

# update live status
curl -X POST "http://localhost:8105/tracking/1?status=ON_TRIP&location=Main%20St"

# see ride list
curl http://localhost:8103/rides
```

Notes
- H2 in-memory DBs; data resets on restart.
- Dispatch currently uses mock round-robin drivers; integrate with driver-service for real availability.
- Topics auto-created by `common` when Kafka reachable.
