# Test 3: Complete Maven Microservices with JPA & H2

This test provides two fully functional Maven-based Spring Boot projects.

## Project Structure
- **department-service**: Port 8081 | SQL Table `departments` | H2 Database `deptdb`
- **employee-service**: Port 8082 | SQL Table `employees` | H2 Database `empdb`

## How it works (Database version):
1. **Persistence**: Unlike Test 2, where we used a `Map`, here we use **Spring Data JPA**.
2. **H2 Database**: We use an In-Memory database. You can see the configuration in `application.properties`.
3. **Maven Structure**: Each service has its own `pom.xml`, following the standard `src/main/java` and `src/main/resources` folder structure.

## Deployment Instructions:
1. Run `DepartmentApplication` (Port 8081).
2. Run `EmployeeApplication` (Port 8082).
3. Post data to `localhost:8081/departments`.
4. Post data to `localhost:8082/employees`.
5. Get full details from `localhost:8082/employees/{id}`.

## Key Learning:
In this phase, you are learning how to bridge the gap between **Web APIs** and **SQL Databases** in a microservice environment.
