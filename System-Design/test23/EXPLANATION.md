# Test 23: Sticky Sessions vs Stateless

## Simple Explanation
When you have multiple servers behind a Load Balancer, what happens when a user logs in?

## 1. Sticky Sessions (Stateful)
The Load Balancer remembers which server a user "belongs" to.
- **How**: It adds a cookie to the user's browser.
- **Problem**: If that server crashes, the user is logged out! It's also harder to balance the load equally.

## 2. Stateless (Modern Standard)
The server doesn't "remember" anyone. Every request contains a Token (like JWT).
- **How**: User logs in → Gets a JWT. User sends JWT in EVERY future request.
- **Benefit**: Any server can handle the request! If Server A crashes, the user doesn't even notice—Server B handles the next click.

## When to use?
- Always aim for **Stateless** for new microservice projects. It's much easier to scale!
- Use **Sticky Sessions** only for old legacy apps that store "User Object" in RAM (`HttpSession`).
