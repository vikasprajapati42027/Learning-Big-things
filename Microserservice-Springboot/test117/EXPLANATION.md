# Test 117: Custom Health Indicators

Telling Kubernetes exactly when your app is BROKEN.

## Key Files:
- `ExternalApiHealthIndicator.java`: Logic for checking external dependencies.
- `EXPLANATION.md`: Liveness vs Readiness probes.

## Why use it?
Your app might be "Running" but unable to do work because a third-party payment API is down. A custom health indicator exposes this status. Kubernetes will see the "DOWN" status and automatically stop sending traffic to this instance.
