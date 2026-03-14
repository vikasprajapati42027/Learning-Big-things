# Test 51: Circuit Breaker + Fallback

## 🛡️ 1. What is a Circuit Breaker?
Preventing cascading failures. If the `Inventory-Service` is down, we shouldn't keep sending requests and wasting threads. We "trip" the circuit.

## 🖱️ 2. Fallback Mechanism (The Logic requested)
When the main service fails, the `@CircuitBreaker` annotation catches the exception and immediately calls the `fallbackMethod`.
- **Primary**: Try to call Inventory.
- **Secondary (Fallback)**: Return a friendly message or cached data.

## 🚀 3. Resilience4j
This is the modern replacement for Netflix Hystrix. It is lightweight and works perfectly with Functional Programming.
