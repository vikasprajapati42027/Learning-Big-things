# Test 9: OpenFeign (Declarative REST Client)

The professional way to talk to other microservices.

## The Problem with RestTemplate:
In Tests 3 to 7, we used **`RestTemplate`**. It requires:
1. Creating a `Bean`.
2. Writing long URLs like `http://SERVICE-NAME/api/v1/path/`.
3. Managing complex JSON conversion.
It's messy and has too much boilerplate code.

## The Solution (OpenFeign):
With **Feign**, you don't write any code to "Call" the other service. You just write an **Interface**.

### How it works:
1. **Define Interface**: You create a Java interface and put **`@FeignClient(name = "OTHER-SERVICE")`** on top.
2. **Abstract Methods**: You write a method that looks like a Controller method (`@GetMapping`).
3. **Magic**: At runtime, Spring Cloud creates the implementation of that interface and handles the network call, load balancing, and JSON conversion automatically.

---

## 🔑 Key Code:
Look at `employee-service/src/.../feign/DepartmentClient.java`:
```java
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {
    @GetMapping("/departments/{id}")
    DepartmentDTO getDepartmentById(@PathVariable Long id);
}
```
In your Service, you just inject `DepartmentClient` and call it like a local method!

## Why is this "Advanced"?
It makes your code look incredibly clean. It feels like you are calling a local Java class, but in reality, Spring is making a network call to a completely different server. 

## Integration:
Feign is designed to work perfectly with **Eureka** (to find services) and **LoadBalancer** (to pick an instance) out of the box.
