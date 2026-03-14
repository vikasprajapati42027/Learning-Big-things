# Test 80: Spring Cloud Bus

Automating the Refresh process.

## The Problem:
If you have 50 instances of the same service, calling `/actuator/refresh` on ALL of them manually is impossible.

## The Solution:
Use **Spring Cloud Bus**.
1. You call `/actuator/bus-refresh` on ONE service.
2. That service publishes an event to a message broker (like RabbitMQ).
3. Every OTHER service is listening to that broker. They see the event and refresh themselves!
One call, 50 updates.
