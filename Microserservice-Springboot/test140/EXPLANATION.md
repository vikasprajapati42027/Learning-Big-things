# Test 140: Custom Actuator Endpoints

Exposing your own operational information through the Actuator framework.

## Key Files:
- `CustomActuatorEndpoint.java`: A custom `@Endpoint` accessible at `/actuator/app-info`.
- `EXPLANATION.md`: Building operational dashboards.

## Concept:
Spring Actuator gives you `/health` and `/metrics` by default. You can add your own with `@Endpoint`. Kubernetes calls your `/actuator/health` endpoint every 10 seconds to decide if your pod is healthy. You can customize exactly what it reports.
