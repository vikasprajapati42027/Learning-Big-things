# Test 43: Dockerizing a Spring Boot App

"It works on my machine" is no longer an excuse.

## Dockerfile Example:
```dockerfile
# Use a lightweight JDK 17 image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from target directory
COPY target/myapp-0.0.1-SNAPSHOT.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## Commands:
1. `mvn clean package` (Build the JAR)
2. `docker build -t my-spring-app .` (Build the Image)
3. `docker run -p 8080:8080 my-spring-app` (Run the Container)
