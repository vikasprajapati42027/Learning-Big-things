package TestJava.Test20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Advanced Streams (Java 8+) ===");

        Department engineering = new Department("Engineering", Arrays.asList(
            new Employee("Alice", 28, "Developer"),
            new Employee("Bob", 35, "Manager"),
            new Employee("Charlie", 22, "Developer")
        ));

        Department sales = new Department("Sales", Arrays.asList(
            new Employee("David", 40, "Manager"),
            new Employee("Eve", 29, "Sales Rep")
        ));

        List<Department> company = Arrays.asList(engineering, sales);

        // 1. flatMap: Flattening nested lists
        // We have a List of Departments, each containing a List of Employees.
        // We want ONE flat List of all Employees.
        System.out.println("\n--- 1. Using flatMap ---");
        List<Employee> allEmployees = company.stream()
            .flatMap(dept -> dept.getEmployees().stream()) // Extracts streams of employees and 'flattens' them into one stream
            .collect(Collectors.toList());

        System.out.println("All Employees in Company: " + allEmployees);

        // 2. groupingBy: Grouping elements by a specific property
        // Let's group all employees by their role!
        System.out.println("\n--- 2. Using groupingBy ---");
        Map<String, List<Employee>> employeesByRole = allEmployees.stream()
            .collect(Collectors.groupingBy(Employee::getRole));

        // Print the grouped map
        employeesByRole.forEach((role, empList) -> {
            System.out.println("Role: " + role + " -> " + empList);
        });

        // 3. average: Calculating the average age
        System.out.println("\n--- 3. Using mapToInt & average ---");
        double averageAge = allEmployees.stream()
            .mapToInt(Employee::getAge)
            .average()
            .orElse(0.0);
        
        System.out.println("Average Company Age: " + averageAge);
    }
}
