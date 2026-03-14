# Test 7: Distributed Tracing (Micrometer & Zipkin)

Track your requests across the entire microservice landscape.

## The Problem:
In a microservice system, a simple "Get Employee" request goes through:
1. **API Gateway**
2. **Employee Service**
3. **Department Service**

If the request is slow or fails, how do you know which service caused it? Checking logs on 3 different servers and matching timestamps is impossible!

## The Solution (Distributed Tracing):
We give every request a unique **Trace ID**. This ID travels with the request from service to service. 

### Key Concepts:
- **Trace ID**: One ID for the whole journey (e.g., `abc-123`).
- **Span ID**: A unique ID for one specific "hop" (e.g., the call from Gateway to Employee).
- **Log Correlation**: Every log message will now show the Trace ID automatically!

---

## 🔑 How we enabled it:
In Spring Boot 3, we use **Micrometer Tracing**. 
1. Added the `micrometer-tracing-bridge-brave` dependency.
2. Configured the log pattern in `application.properties`:
   `logging.pattern.level=%5p [service-name, traceId, spanId]`

## How to test this:
1. Start all services.
2. Call `http://localhost:9191/employees/101`.
3. Look at the console logs of **ALL** services (Gateway, Employee, and Department).
4. **Result**: You will see the SAME `traceId` in all three consoles! 
   `INFO [EMPLOYEE-SERVICE, 65f3a..., ab12c...]`
   `INFO [DEPARTMENT-SERVICE, 65f3a..., cd34e...]`

---

## Visualizing with Zipkin (Advanced):
If you run a **Zipkin Server** (using Docker), all these services will send their data there. You can then open a web UI to see a visual timeline of how long each service took. It's like a "Map" of your request!
