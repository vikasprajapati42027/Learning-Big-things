# Test 54: Spring WebFlux (Reactive Web)

Handle 10,000 users with just 4 threads.

## Web MVC (Old) vs WebFlux (New):
- **Web MVC**: Blocking. Every request waits for the DB to finish.
- **WebFlux**: Reactive. The server says "Call me when data is ready" and goes to handle other users.

## Why Reactive?
It's about **Scalability**. It uses very little memory because it doesn't create thousands of threads. It's perfect for microservices and cloud-native apps.
