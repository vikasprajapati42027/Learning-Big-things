# How Service-to-Service calling works in Code

To make it simple, we split the code into **Controller** and **Service**.

### 1. The Manager (Controller)
The Controller is like a waiter. It takes the order from the user and gives it to the Service.
```java
@GetMapping("/{id}")
public EmployeeResponse getEmployee(@PathVariable Long id) {
    return employeeService.getEmployeeDetails(id); // Pass to service
}
```

### 2. The Cook (Service) - Where the calling happens
The Service has the real logic. Here is the exact code that calls the other service:

```java
public EmployeeResponse getEmployeeDetails(Long empId) {
    // Stage 1: Get Employee data
    Employee emp = repo.find(empId); 

    // Stage 2: THE CALL
    // We use RestTemplate (like a browser) to call the other service's URL
    String url = "http://localhost:8080/departments/" + emp.getDeptId();
    Department dept = restTemplate.getForObject(url, Department.class);

    // Stage 3: COMBINE
    return new EmployeeResponse(emp, dept);
}
```

---

### Important explanation:
- **`restTemplate.getForObject(url, Class)`**: This is the magic line. 
  - `url`: The address of the other microservice.
  - `Department.class`: Tells Spring to automatically convert the JSON it gets from the other service into a Java `Department` object.
- **Microservice Separation**: Even though these are in the same project for this test, in a real environment, they would be on separate servers. The code remains exactly the same!
