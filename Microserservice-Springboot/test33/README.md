# Test 33: Bulkhead Pattern (Resilience4j)

Isolating failures to save the whole ship.

## Concept:
On a ship, a **Bulkhead** is a wall. If one room floods, the bulkhead stops the water from sinking the whole ship.

## In Microservices:
What if your `Payment Service` is slow? It might use up all the 200 threads in your `Order Service`. Now, even if someone wants to "Browse Products" (which is fast), they can't because all threads are stuck waiting for Payments.

## The Solution:
You create two "pools":
- Pool A: 50 threads for Payments.
- Pool B: 150 threads for Browsing.
If Payments get slow, it can only steal 50 threads. The other 150 are safe!

## Key Annotation:
`@Bulkhead(name = "paymentService")`
