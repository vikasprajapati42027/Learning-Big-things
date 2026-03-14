# Test 4: Service Discovery with Netflix Eureka

Welcome to the **"Advanced"** part of Microservices! 

## What is Eureka?
Eureka is like a **Phonebook** for microservices.
In Test 3, we hardcoded `localhost:8081`. But in the real world, IP addresses change constantly.

## How it works:
1. **Eureka Server**: This is the "Phonebook" service on Port 8761.
2. **Registration**: When Department and Employee services start, they "Register" themselves with Eureka. 
3. **Lookup**: When Employee Service needs Department Service, it asks Eureka: "Where is 'DEPARTMENT-SERVICE'?" 
4. **Result**: Eureka gives the current IP/Port, and the Employee Service makes the call.

---

## 🔑 Key Code changes:
1. **The Server**: Added `@EnableEurekaServer` in `service-registry`.
2. **The Client**: Added `@EnableDiscoveryClient` in both services.
3. **The Call**: 
   - Instead of `http://localhost:8081`, we now call `http://DEPARTMENT-SERVICE`.
   - We added **`@LoadBalanced`** to our `RestTemplate` bean. This allows Spring to translate the service name into a real IP address.

---

## Order of Execution:
1. Start **`ServiceRegistryApplication`** (Port 8761).
2. Wait a few seconds, then open `http://localhost:8761` in your browser. You will see the Eureka Dashboard!
3. Start **`DepartmentApplication`**.
4. Start **`EmployeeApplication`**.
5. Refresh the dashboard; you will see both services registered!

Now the services can talk to each other without knowing their exact IP addresses. This is **Service Discovery**!
