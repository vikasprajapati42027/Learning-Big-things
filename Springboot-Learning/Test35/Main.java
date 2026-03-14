package Test35;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * @Query Annotation:
 * Writing manual queries using JPQL or Native SQL.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL: Java Persistence Query Language (Uses Entity and Field names)
    @Query("SELECT e FROM Employee e WHERE e.salary > :minSalary")
    List<Employee> findHighPaid(@Param("minSalary") double minSalary);

    // Native SQL: Uses actual database Table and Column names
    @Query(value = "SELECT * FROM employees WHERE department = ?1", nativeQuery = true)
    List<Employee> findByDept(String dept);
}

class Employee {
    private Long id;
    private String name;
    private double salary;
    private String department;
}
