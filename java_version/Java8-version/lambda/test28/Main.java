package java_version.Java8_version.lambda.test28;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Write a Java 8 program to get names of all employees.
 * Q: Filter employees with salary greater than 60000.
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("28. All employee names: " + names);

        List<Employee> highSalary = employees.stream()
                .filter(e -> e.getSalary() > 60000)
                .collect(Collectors.toList());
        System.out.println("   Employees salary > 60000: " + highSalary);
    }
}
