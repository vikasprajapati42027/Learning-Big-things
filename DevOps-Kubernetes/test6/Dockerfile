# Stage 1: Build
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY EmployeeService.java .
RUN javac EmployeeService.java

# Stage 2: Final Light Image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/EmployeeService.class .
CMD ["java", "EmployeeService"]
