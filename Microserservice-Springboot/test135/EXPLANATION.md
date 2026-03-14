# Test 135: Controller Slice Tests (@WebMvcTest)

Testing only the web layer without starting the full Spring context.

## Key Files:
- `MockMvcTest.java`: Uses `@WebMvcTest` + `MockMvc` to test HTTP mapping without a database.
- `EXPLANATION.md`: Why slice tests are faster than @SpringBootTest.

## Concept:
`@WebMvcTest` starts ONLY the web layer (controllers, filters, interceptors) — not JPA, not Redis. This makes tests run in milliseconds. Use `@MockBean` to replace your service with a Mockito fake so you can test controller behavior in isolation.
