# Test 78: Spring Cloud Bus

Broadcasting configuration changes to all microservices at once.

## Key Files:
- `BusApplication.java`: Main app.
- `EXPLANATION.md`: One signal to refresh them all.

## Concept:
When you change a property in Git, you don't want to restart 50 services. With Spring Cloud Bus, you send one POST request to `/actuator/bus-refresh` on one service, and it tells everyone else via RabbitMQ/Kafka: "Hey, new config is ready, reload now!"
