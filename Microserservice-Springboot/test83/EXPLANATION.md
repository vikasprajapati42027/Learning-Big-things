# Test 83: Client-Side Load Balancing

Picking the best instance to call without a central bottleneck.

## Key Files:
- `LoadBalancerController.java`: Demonstrates the `@LoadBalanced` annotation.
- `EXPLANATION.md`: Logic of Round Robin and Weighted routing.

## Why use it?
Instead of a hardware load balancer that might fail, every microservice in Spring Cloud knows about all the instances of other services. It picks which one to call (e.g., Instance #2) directly. This is faster and more reliable.
