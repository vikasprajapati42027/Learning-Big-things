# Test 12: Distributed Logging (ELK)

## 📝 1. Why Distributed Logging?
If you have 10 instances of a service, you can't log into 10 servers to read text files. You need a central place to search logs.

## 🔋 2. ELK Components
- **Elasticsearch**: The search engine (Database for logs).
- **Logstash**: The processor (Formats logs).
- **Kibana**: The dashboard (Visualizes logs).

## 🚀 3. Implementation Tip
Use **Logback** with a TCP appender to send logs directly to Logstash in JSON format. This makes searching by `correlationId` or `userId` extremely fast.
