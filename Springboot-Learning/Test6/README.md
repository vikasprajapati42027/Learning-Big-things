# Test 6: REST Basics (@RestController & @GetMapping)

This module explains how to create your first Web API.

## 1. What is REST?
**REST** stands for Representational State Transfer. In simple terms, it's a way for two computers to talk to each other over the internet using HTTP.

## 2. Key Annotations

### `@RestController`
- Tells Spring that this class handles web requests.
- It’s "RESTful" because it sends data (like JSON) instead of returning a view (like HTML).

### `@GetMapping`
- Specifies that a method should handle a **GET** request for a specific URL.

## 3. Automatic JSON Conversion
Spring uses a library called **Jackson** by default. 
- If you return a `String`, it sends the raw string.
- If you return a **Java Object** (like `UserResponse`), Jackson converts it into a `JSON` string automatically.

## How it works:
1. You run the app.
2. An embedded web server (like Tomcat) starts and waits for requests on port 8080.
3. You open a browser and go to `localhost:8080/user`.
4. Spring finds the `@GetMapping("/user")` in `HelloController`.
5. It runs the method, gets the `UserResponse` object, converts it to JSON, and sends it to your browser.

**Example JSON Response:**
```json
{
  "name": "Vikas",
  "role": "Java Developer"
}
```
