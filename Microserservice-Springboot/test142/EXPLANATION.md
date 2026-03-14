# Test 142: WebClient (Non-Blocking HTTP)

The modern replacement for RestTemplate.

## Key Files:
- `WebClientController.java`: Uses `WebClient` to make a non-blocking call to a public API.
- `EXPLANATION.md`: Why RestTemplate is now deprecated.

## Concept:
`RestTemplate.getForObject()` blocks a thread while waiting for the response. `WebClient.get().retrieve()` returns a `Mono<T>` immediately and notifies you when data arrives — freeing your thread to handle other requests. It's the correct way to make HTTP calls in modern Spring applications.
