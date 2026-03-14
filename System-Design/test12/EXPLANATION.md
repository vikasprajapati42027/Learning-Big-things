# Test 12: API Gateway Pattern

## Simple Explanation
When you have 50 microservices, you don't want the frontend to call 50 different URLs. You create one **Gateway** that acts as the single entry point.

## What it does:
1. **Routing**: Moves request for `/users` to User Service and `/orders` to Order Service.
2. **Authentication**: Checks the JWT token at the door so individual services don't have to.
3. **Rate Limiting**: Stops brute-force attacks at the entry point.
4. **Aggregation**: Can call 3 services and combine their data into one JSON response for the frontend.

## Diagram
```
Client → [ API Gateway ] → User Service
                        → Order Service
                        → Payment Service
```

## Popular Gateways
- **Spring Cloud Gateway** (Best for Java)
- **Kong** (High performance)
- **Netflix Zuul** (Older, but famous)
- **AWS API Gateway** (Managed service)
