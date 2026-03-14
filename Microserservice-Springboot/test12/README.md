# Test 12: Centralized Logging (ELK Stack)

Finding a needle in a haystack of 100 servers.

## The Problem:
Every microservice writes logs to its own local file. To find why "User #5" failed, you'd have to log into 10 servers manually.

## The Solution (ELK):
1. **L (Logstash)**: A "vacuum cleaner" that sucks up logs from all microservices.
2. **E (Elasticsearch)**: A powerful database that stores and indexes all those logs.
3. **K (Kibana)**: A beautiful dashboard where you can search for "User #5" and see every log message from every service in one timeline.

## Spring Boot Role:
We use a library like `logstash-logback-encoder` to send logs as JSON directly to the ELK stack.
