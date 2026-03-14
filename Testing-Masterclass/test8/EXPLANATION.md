# Test 8: Performance Testing with JMeter

## Simple Explanation
JMeter simulates thousands of users hitting your API simultaneously
to find bottlenecks before they happen in production.

## JMeter Test Plan Structure
```
Test Plan
└── Thread Group (1000 users, ramp up over 60 seconds)
    ├── HTTP Request: GET /api/products
    ├── HTTP Request: POST /api/orders
    ├── Listeners:
    │   ├── Summary Report (requests/sec, avg response time)
    │   ├── Response Time Graph
    │   └── Error Rate Graph
    └── Assertions: Response time < 500ms
```

## Key Metrics
| Metric | Good | Warning | Critical |
|--------|------|---------|---------|
| Response Time (p95) | < 200ms | 200-500ms | > 500ms |
| Error Rate | 0% | < 1% | > 1% |
| Throughput | > 1000 req/s | 500-1000 | < 500 |
| CPU on Server | < 60% | 60-80% | > 80% |

## What to Look For
1. **Memory leaks** — Response time steadily increases over time
2. **DB bottleneck** — CPU low, response time high (queries are slow)
3. **Thread pool exhaustion** — Queue depth increases (Tomcat can't accept more)
