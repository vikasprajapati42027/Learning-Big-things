# Test 52: Circuit Breaker States

1. **CLOSED**: Everything is fine. Requests flow.
2. **OPEN**: Failure threshold reached. All requests rejected instantly.
3. **HALF-OPEN**: Probe state. Send a few requests to see if the service recovered.
