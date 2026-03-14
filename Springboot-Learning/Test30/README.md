# Test 30: Consuming REST APIs

Modern apps don't work alone. They talk to other APIs.

## Tools:
1. **RestTemplate**: Simple, synchronous client. (Recommended for basic usage).
2. **WebClient**: Part of Spring WebFlux. Modern, reactive, and asynchronous. (Replaces RestTemplate in newer versions).
3. **OpenFeign**: Declarative client. You just write an interface, and Spring generates the client.

## Tips:
- Always use a `Builder` to create your clients (to inject timeouts).
- Handle exceptions like `HttpClientErrorException` (for 404/401 errors).
