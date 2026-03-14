# Test 80: Spring Cloud Bus

Broadcasting config changes to all services with one HTTP call.

## Key Files:
- `CloudBusApplication.java`: Main app with bus enabled.
- `application.properties`: Config to expose the `bus-refresh` endpoint.
- `EXPLANATION.md`: How a single message refreshes 50 services at once.

## Concept:
POST to `/actuator/bus-refresh` on ONE service → that service publishes an event to RabbitMQ → every OTHER service listening refreshes. One call refreshes your entire fleet of services, no restarts needed.
