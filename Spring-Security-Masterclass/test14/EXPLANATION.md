# Test 14: Stateless Session Management

## Simple Explanation
By default, Spring Boot creates a **Session** (JSESSIONID cookie) for every user. For REST APIs, this is usually unnecessary and bad for scaling. 

## SessionCreationPolicy.STATELESS
This tells Spring Security: "Do NOT create a session, and do NOT use an existing session to check if the user is logged in."

## Why go Stateless?
1. **Scalability**: Any server in your cluster can handle the request because no session is saved in memory locally.
2. **Mobile/Desktop Apps**: These apps usually prefer tokens (JWT) over cookies.
3. **Memory Saving**: No session objects taking up RAM on the server.

## If it's Stateless, how does it know who I am?
Every single request must contain credentials (like a JWT in the `Authorization` header). The server validates the token for EVERY request.

## Security Rule
If your API is **Stateless**, you should generally **Disable CSRF** protection, because CSRF protection relies on sessions to work!
