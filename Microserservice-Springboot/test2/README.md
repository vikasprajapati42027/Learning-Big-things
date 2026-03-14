# Test 2: Employee & Department (Service-to-Service Communication)

This project demonstrates how two microservices talk to each other to get a complete set of data.

---

## 1. The Scenario
Imagine we have two separate databases:
- **Department DB**: Stores `id`, `name`, and `location`.
- **Employee DB**: Stores `id`, `name`, and `departmentId`.

When a user asks for "Employee details", we want to show them the **Department Name** too. But the Employee service doesn't have that name! It only has the `departmentId`.

---

## 2. How it works (Step-by-Step)

1. **User Request**: The user calls `GET /employees/101`.
2. **Employee Controller**: 
   - Finds the employee "Vikas" in its map.
   - Sees that Vikas belongs to `departmentId: 1`.
3. **The Communication (Microservice Magic)**:
   - The Employee service uses **`RestTemplate`** to send a new request to the Department service: `GET /departments/1`.
4. **Department Controller**:
   - Receives the call.
   - Finds Department "IT" with location "New York".
   - Returns the JSON data back to the Employee service.
5. **Combined Response**:
   - The Employee service takes its own data + the data it got from the Department service.
   - Wraps them in an **`EmployeeResponse`** object.
   - Sends the final combined JSON back to the user.

---

## 3. Why is this important?
This is called **Internal Service Communication**. 

In a real world:
- The `EmployeeController` would be running on Server A (Port 8081).
- The `DepartmentController` would be running on Server B (Port 8082).
- They talk over the network using JSON.

## 4. Key Java Tools used:
- **`RestTemplate`**: The "Phone" used by one service to call another.
- **`@PathVariable`**: To grab the ID from the URL.
- **DTO (Data Transfer Object)**: The `EmployeeResponse` class which is used ONLY to send data to the user.
