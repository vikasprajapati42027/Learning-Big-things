# Test 14: Sidecar Pattern

Integrating "The Old" and "The Different".

## Concept:
What if you have a legacy application written in **C++** or **PHP** that needs to join your Spring Cloud ecosystem? You can't rewrite it in Java.

## The Solution (Sidecar):
You run a small Spring Boot "Sidecar" app next to the legacy app on the same server.
- The **Sidecar** registers with Eureka.
- The **Sidecar** handles the health checks.
- When other Spring apps want to talk to the PHP app, they talk to the Sidecar, and the Sidecar forwards the request locally.

It's like an "Interpreter" for your non-Java apps!
