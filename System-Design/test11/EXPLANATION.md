# Test 11: Microservices vs Monolith

## 1. Monolith
One big application. All code is in one repository and deployed as one unit.
- **Pros**: Easy to build, easy to test, fast inter-process calls.
- **Cons**: Slow deployments (must redeploy EVERYTHING), hard to scale different parts, technology lock-in.

## 2. Microservices
The app is split into small independent services (e.g., User Service, Order Service).
- **Pros**: Deploy parts independently, scale only what's needed, use different languages for different services.
- **Cons**: Complex setup, network latency, distributed data is hard to manage.

## Comparison Table
| Feature | Monolith | Microservices |
|---------|----------|---------------|
| Deployment | All or Nothing | One at a time |
| Scaling | Scale everything | Scale specific services |
| Debugging | Direct stack traces | Needs distributed tracing (Zipkin/Jaeger) |
| Team Setup | Everyone in one repo | Small teams own a service |

## When to use?
- **Monolith**: Startups, small teams, simple apps.
- **Microservices**: Large scale, many teams, high complexity.
