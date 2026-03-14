# Test 44: Service Discovery (Eureka)

How do services find each other?

## The Problem:
Imagine you have a `Payment-Service`. If it scales to 10 instances, what IP should the `Order-Service` call?

## The Solution (Eureka):
1. **Eureka Server**: The Registry.
2. **Eureka Client**: Every microservice registers its name and IP with the server.
3. **Lookup**: `Order-Service` asks Eureka for the IP of `Payment-Service`.

## Why?
No more hardcoded IP addresses in `application.properties`!
