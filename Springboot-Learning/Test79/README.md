# Test 79: Runtime Configuration Refresh

Change settings on the fly.

## The Problem:
Normally, `@Value` fields are set when the app starts. If you change a property in Config Server, the app won't see it until you restart.

## The Solution:
Annotate your Controller or Service with **`@RefreshScope`**.
After changing the property in Git, call the endpoint `POST /actuator/refresh`. 
Spring will instantly re-read the value and update the bean in memory!
