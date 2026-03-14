# Test 78: Centralized Configuration

Stop copying `application.properties` to 20 different services.

## How it works:
1. **Config Server**: Connected to a Git repo (e.g., GitHub).
2. **Microservices**: At startup, they ask Config Server: "Hey, I'm 'payment-service' in 'prod' mode, what are my settings?".

## Benefit:
You can update a configuration (like changing a timeout) in the Git repo, and it becomes available to all services instantly without rebuilding the code.
