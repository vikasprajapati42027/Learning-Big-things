# Test 5: API Gateway (Spring Cloud Gateway)

One entry point to rule them all.

## The Problem:
In Test 4, the user had to know the addresses of multiple services:
- `http://localhost:8081/departments`
- `http://localhost:8082/employees`

As you add more services, this becomes a nightmare for the front-end developers.

## The Solution (API Gateway):
An **API Gateway** acts as a single door for your entire system.
The user only calls **ONE** URL: `http://localhost:9191/...`

## How it works:
1. **Routing**: If the request is `/departments/`, the Gateway forwards it to the `DEPARTMENT-SERVICE`.
2. **Security**: You can check Auth tokens once at the Gateway instead of in every microservice.
3. **Load Balancing**: Like the employee service, it uses Eureka to find where the services are currently running.

---

## 🔑 Key Configuration:
Look at `api-gateway/src/main/resources/application.properties`:
```properties
# If path starts with /departments/, go to DEPARTMENT-SERVICE
spring.cloud.gateway.routes[0].uri=lb://DEPARTMENT-SERVICE
spring.cloud.gateway.routes[0].predicates[0]=Path=/departments/**
```

## Order of Execution:
1. **Service Registry** (Port 8761)
2. **Department Service** (Port 8081)
3. **Employee Service** (Port 8082)
4. **API Gateway** (Port 9191)

Now, try calling:
- `GET http://localhost:9191/employees/101`
- `GET http://localhost:9191/departments/1`

You no longer need ports 8081 or 8082. **One URL, Multiple Services!**
