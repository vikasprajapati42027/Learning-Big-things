# Test 1: Introduction to Microservices (Q&A)

Welcome to the **Microservices-Springboot** journey! Let's start with the most basic questions explained in a simple way.

---

### Q1: What is a Microservice?
**Simple Answer:** 
Imagine a huge "Shopping App". 
- In **Monolithic**, everything (Login, Products, Payment, Shipping) is in one big project. If the Shipping part breaks, the whole app might crash.
- In **Microservices**, we break it into small, independent apps: a "Login App", a "Product App", and a "Payment App". They talk to each other over the network.

### Q2: Why use Microservices?
**Simple Answer:**
1. **Scalability:** If millions of people are searching for products but only few are buying, you can scale *only* the "Product service" without wasting money on the "Payment service".
2. **Independence:** Team A can use Java for the Login service, while Team B uses Python for the AI service.
3. **Fault Tolerance:** If the "Shipping service" goes down, users can still "Login" and "Browse Products".

### Q3: How do Microservices talk to each other?
**Simple Answer:**
Most commonly through:
1. **REST API (HTTP):** Service A calls Service B using a URL (Synchronous).
2. **Messaging (Kafka/RabbitMQ):** Service A leaves a message in a "box", and Service B picks it up whenever it's ready (Asynchronous).

---

### Q4: Basic Coding Task
**Question:** Create a simple Spring Boot "Microservice" that returns a list of "Orders".

**Answer:**
```java
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public List<String> getOrders() {
        return List.of("Order #101", "Order #102", "Order #103");
    }
}
```

---

### Key takeaway for Test 1:
A Microservice is just a small Spring Boot application that does **ONE** thing very well and works independently.
