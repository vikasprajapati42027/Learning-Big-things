# Test 25: Monitoring (Prometheus & Grafana)

The "Control Center" for your applications.

## Prometheus:
It "scrapes" (pulls) metrics from your code using the Spring Boot Actuator. It knows exactly how much CPU, memory, and how many successful/failed requests you have.

## Grafana:
A dashboard tool that connects to Prometheus. It shows you beautiful graphs like:
- "Orders per minute"
- "Average response time"
- "Server Health"

If something goes wrong, it sends an alert to your phone!
