# Test 62: Log Aggregation (ELK Stack)

Collecting all logs in one central, searchable database.

## Key Files:
- `LogApplication.java`: Demonstrates standard logging.
- `EXPLANATION.md`: How Logstash, Elasticsearch, and Kibana work together.

## Why use it?
Searching through text files on 20 different servers is impossible. Log Aggregation pushes every log line to Elasticsearch, where you can search "Find me all errors for 'User-123' across all services" in seconds.
