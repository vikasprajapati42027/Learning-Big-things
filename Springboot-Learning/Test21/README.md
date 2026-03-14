# Test 21: Spring Boot Actuator

Monitoring is essential for production applications.

## How to enable:
Add the dependency: `spring-boot-starter-actuator`

## Configuration:
By default, only `/health` is visible. To show more:
`management.endpoints.web.exposure.include=health,info,metrics`

## Use Cases:
1. **Health Checks**: Used by Kubernetes to see if your pod is alive.
2. **Metrics**: See how much memory your app is using.
3. **Auditing**: Track user logins or database changes.
