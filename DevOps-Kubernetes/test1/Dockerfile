# Stage 1: Build & Run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY EmployeeService.java .
# Compile the Java file
RUN javac EmployeeService.java
# Run the application
CMD ["java", "EmployeeService"]
