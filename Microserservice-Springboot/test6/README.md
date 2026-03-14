# Test 6: Circuit Breakers (Fault Tolerance)

Don't let one failing service crash your entire system.

## The Problem:
If `Employee Service` calls `Department Service`, and `Department Service` is down or slow, the `Employee Service` might wait forever, run out of memory, and crash too. This is a **Cascading Failure**.

## The Solution (Circuit Breaker):
Like a fuse in your house, the Circuit Breaker "breaks" the connection if it detects too many failures.

### The 3 States:
1. **CLOSED**: Everything is normal. Requests go through.
2. **OPEN**: The service is failing. Stop calling it immediately. Call the **Fallback** method instead.
3. **HALF-OPEN**: After some time, let a few requests try to go through to see if the service is back up.

---

## 🔑 Key Code (Resilience4j):
In `EmployeeService.java`, we added:
```java
@CircuitBreaker(name = "employeeService", fallbackMethod = "dummyDepartment")
public ResponseDTO getEmployeeById(Long id) { ... }

public ResponseDTO dummyDepartment(Long id, Exception e) {
    // Return "Service Unavailable" instead of an error page
    return new ResponseDTO(emp, dummyDept);
}
```

## How to test this:
1. Start everything (Eureka, Gateway, Employee, Department).
2. Call `http://localhost:9191/employees/101`. It works!
3. **Stop the Department Service manually.**
4. Call the URL again.
   - **Result**: You won't get an Error 500. You will get the employee details + a department name that says **"Service Unavailable"**.
   - Your application is still running and healthy!

---

## Why is this important?
In a professional system, users should never see a "White Label Error Page". Even if one part of your app is broken, the rest of the app should remain functional.
