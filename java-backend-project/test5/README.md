# Ride Booking Microservices (test5)

Java 17 / Spring Boot 3.2.x multi-module system that models an Uber-like flow: riders request rides, dispatch assigns drivers, tracking publishes live status via Kafka topics.

Modules
- common: shared events, Kafka topics + auto-creation config
- rider-service (port 8111): CRUD riders
- driver-service (port 8112): CRUD drivers, tracks availability (mocked)
- booking-service (port 8113): accepts ride requests, emits `ride.requested`
- dispatch-service (port 8114): consumes `ride.requested`, assigns mock driver, emits `ride.assigned`
- tracking-service (port 8115): consumes `ride.assigned`, persists status, re-broadcasts `ride.status`, REST to update/read status

Prerequisites
- Java 17, Maven 3.9+
- Docker (for Kafka + Zookeeper) or Kafka on localhost:9092

How to run
```bash
cd java-backend-project/test5

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

# Run services (each in its own terminal)
mvn -pl rider-service spring-boot:run
mvn -pl driver-service spring-boot:run
mvn -pl booking-service spring-boot:run
mvn -pl dispatch-service spring-boot:run
mvn -pl tracking-service spring-boot:run
```

Quick test (curl)
```bash
# add rider
curl -X POST http://localhost:8111/riders -H 'Content-Type: application/json' \
  -d '{"name":"Alice","phone":"99999"}'

# request ride (triggers Kafka event)
curl -X POST http://localhost:8113/rides -H 'Content-Type: application/json' \
  -d '{"riderId":1,"pickup":"Downtown","dropoff":"Airport"}'

# check tracking (after dispatch assigns)
curl http://localhost:8115/tracking/1

# update live status
curl -X POST "http://localhost:8115/tracking/1?status=ON_TRIP&location=Main%20St"

# list rides
curl http://localhost:8113/rides
```

Notes
- H2 in-memory DBs; data resets on restart.
- Driver matching is mocked round-robin; wire to driver-service availability for real logic.
- Kafka topics auto-created when broker reachable.
