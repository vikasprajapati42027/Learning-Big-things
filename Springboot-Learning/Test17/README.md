# Test 17: Spring Security (Basics)

Spring Security is a powerful and highly customizable authentication and access-control framework.

## Default Behavior:
When you add `spring-boot-starter-security`:
1. All endpoints are protected by **HTTP Basic Authentication**.
2. A default user `user` is created.
3. A random password is generated and printed in the logs at startup.
4. It enables **CSRF** protection and **XSS** protections automatically.

## How to test:
1. Run the app.
2. Visit `http://localhost:8080/secure`.
3. A browser popup will ask for username and password.
