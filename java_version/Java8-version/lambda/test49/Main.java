package java_version.Java8_version.lambda.test49;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: You have departments and employees. List all department names that have at least one employee with salary > 70k.
 * A: Filter employees salary>70k, map to department, distinct (or use department list and anyMatch)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        List<String> deptsWithHighEarner = employees.stream()
                .filter(e -> e.getSalary() > 70000)
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("49. Departments with at least one employee >70k: " + deptsWithHighEarner);
    }
}
