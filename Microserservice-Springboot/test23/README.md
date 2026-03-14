# Test 23: Service Mesh (Istio)

Managing the "Network" between services.

## The Problem:
As you have 100 services, security (mTLS) and retries become hard to manage in code.

## The Solution:
A **Service Mesh** (like Istio) puts a "Proxy" next to every service.
- The Proxy handles encryption (Security).
- The Proxy handles retries (Resilience).
- The Proxy handles traffic routing (A/B Testing).

Your developer doesn't write any network logic. The "Mesh" handles it!
