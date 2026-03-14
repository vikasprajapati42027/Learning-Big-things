# Test 111: Service Mesh (Istio / Linkerd)

Handling all cross-cutting network concerns at the infrastructure level.

## Key Files:
- `ServiceMeshApplication.java`: A clean service that has zero networking code — the mesh handles it.
- `EXPLANATION.md`: Security and resilience without writing one line of code.

## Concept:
A Service Mesh injects a "Sidecar Proxy" (Envoy) next to every service. This proxy intercepts ALL traffic, automatically adding mTLS encryption, circuit breaking, retry logic, and detailed metrics — without your developer writing one line of that code.
