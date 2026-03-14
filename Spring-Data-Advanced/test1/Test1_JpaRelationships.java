package com.example.jpa;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// Test 1: JPA Entity Relationships
@Entity
class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // One Department → Many Employees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee2> employees;

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Employee2> getEmployees() { return employees; }
}

@Entity
class Employee2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Many Employees → One Department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Department getDepartment() { return department; }
}

interface DeptRepository extends JpaRepository<Department, Long> {
    // JOIN FETCH to prevent N+1 problem
    @Query("SELECT DISTINCT d FROM Department d JOIN FETCH d.employees")
    List<Department> findAllWithEmployees();
}

public class Test1_JpaRelationships {
    // Run with Spring Boot — see Hibernate SQL in logs
}
