# Test 46: Feign Client (Declarative REST)

Stop using RestTemplate for service-to-service calls.

## Why Feign?
- **Cleaner**: No more URL building or JSON parsing code.
- **Eureka Integration**: Feign automatically looks up service names in Eureka.
- **Load Balancing**: Integrated with **Spring Cloud LoadBalancer** to handle multiple instances of a service.
