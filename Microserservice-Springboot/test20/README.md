# Test 20: Dockerizing Microservices

"It works on my machine" is no longer an excuse.

## What is a Container?
A Docker container includes your JAR file + the Operating System (Linux) + the Java Runtime. Everything is bundled into one **Image**.

## The Dockerfile:
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/my-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## Benefit:
You can build the image once and run it on your laptop, the testing server, or the cloud. It will behave EXACTLY the same way every time.
