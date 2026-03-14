# Test 12: MockMvc - Controller Testing

## Simple Explanation
`MockMvc` allows you to test your REST Controllers without actually starting a full Tomcat server. It simulates HTTP requests and checks the HTTP response.

## Why use it?
- **Speed**: Much faster than `@SpringBootTest`.
- **Isolation**: Focus only on the Controller (mapping, status codes, JSON format).
- **Security**: Can test if certain endpoints return `403 Forbidden`.

## Key Methods
- `perform(get("/..."))`: Send a fake GET request.
- `andExpect(status().isOk())`: Check for `200 OK`.
- `andExpect(jsonPath("$.name").value(...))`: Check the JSON content inside the response using Path syntax.

## @WebMvcTest
This annotation ONLY loads the web layer. It does NOT load services or repositories. If your controller depends on them, you must provide `@MockBean`.
