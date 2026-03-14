# Test 21: Docker Compose

Running your whole system with one command.

## The Problem:
Now you have 5 services, 1 DB, and 1 Kafka. Starting them one by one is painful.

## The Solution:
A `docker-compose.yml` file lists all your services and their relationships.
```yaml
services:
  eureka:
    image: service-registry:latest
  employee-service:
    image: employee-service:latest
    depends_on:
      - eureka
```

Command: `docker-compose up -d`
The whole system starts up, connected and ready!
