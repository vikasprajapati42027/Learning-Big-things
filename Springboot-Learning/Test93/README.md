# Test 93: Performance Tuning

How to make Spring Boot fly.

## JVM Tuning:
1. **Memory**: `-Xms512m -Xmx2g` (Set initial and max heap).
2. **GC (Garbage Collection)**: Use G1GC or ZGC for low latency.
   `-XX:+UseG1GC`

## Spring Boot Optimization:
1. **Exclusions**: Remove `hibernate-validator` if you don't use it.
2. **Lazy Initialization**: `@SpringBootApplication(proxyBeanMethods = false)` or `spring.main.lazy-initialization=true`.
3. **App Actuator**: Use it to find memory leaks and slow endpoints.
4. **Connection Pool**: Tune HikariCP (Max lifetime, Max pool size).
