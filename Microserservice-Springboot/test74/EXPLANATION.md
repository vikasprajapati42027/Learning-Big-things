# Test 74: Time-Series Databases (InfluxDB)

Storing data that changes over time (metrics, sensors, stock prices).

## Key Files:
- `MetricsWriteController.java`: Shows writing timestamped data points.
- `EXPLANATION.md`: Why regular SQL is bad at time-series data.

## Concept:
Time-series data is always associated with a timestamp. InfluxDB is 100x faster than SQL for questions like "Show me CPU % for the last 15 minutes." It's the database behind Grafana dashboards.
