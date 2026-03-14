package java_version.Java8_version.lambda.test29;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Write a Java 8 program to group employees by department.
 * A: Use Collectors.groupingBy(Employee::getDepartment)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("29. Employees by department: " + byDept.keySet());
        byDept.forEach((dept, list) -> System.out.println("   " + dept + ": " + list));
    }
}
