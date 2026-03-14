# Test 25: Monitoring (Prometheus & Grafana)

The visual cockpit of your microservices.

## Key Files:
- `MonitorApplication.java`: App with Actuator enabled.
- `application.properties`: Configuration for exposing the Prometheus endpoint.
- `EXPLANATION.md`: Scrapping metrics for Dashboards.

## Why use it?
Actuator exposes raw data about your app (CPU, RAM, HTTP errors). Prometheus "scrapes" this data every few seconds, and Grafana turns it into beautiful charts so you can see your system's health at a glance.
