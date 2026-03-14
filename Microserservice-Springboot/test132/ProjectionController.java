package com.example.projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;

@Entity
class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String department;
    private double salary; // Not every caller should see this!

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

// Projection interface — only name and department
interface EmployeeSummary {
    String getName();
    String getDepartment();
}

interface EmployeeRepository extends JpaRepository<Employee, Long> {
    java.util.List<EmployeeSummary> findAllProjectedBy();
}

@RestController
@RequestMapping("/employees")
public class ProjectionController {
    private final EmployeeRepository repo;
    ProjectionController(EmployeeRepository r) { this.repo = r; }

    @GetMapping("/summary")
    public java.util.List<EmployeeSummary> getSummary() {
        return repo.findAllProjectedBy(); // only name & dept, no salary!
    }
}
