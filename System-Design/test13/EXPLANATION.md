# Test 13: Service Discovery (Eureka)

## Simple Explanation
In Microservices, services move around (new instances start, old ones die). You can't hard-code IP addresses. **Service Discovery** is like a "Phone Book" where every service registers itself.

## How it works
1. **Eureka Server**: The "Phone Book".
2. **Service Registration**: When User-Service starts, it tells Eureka: "I am 'user-service' and my IP is 192.168.1.10".
3. **Service Discovery**: When Order-Service needs User-Service, it asks Eureka: "Where is 'user-service'?"
4. **Health Check**: If a service dies, Eureka removes it from the book automatically.

## Client-Side Load Balancing
Tools like **Spring Cloud LoadBalancer** (or Netflix Ribbon) fetch the list of IPs from Eureka and choose one (e.g., Round Robin) to call.

## Why use it?
Without it, if you scale from 2 to 5 instances of a service, you'd have to manually update the config of every caller!
