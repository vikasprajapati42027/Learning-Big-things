package java_version.Java8_version.lambda.test43;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Find employees whose name contains "a" (case-insensitive) and salary > 55000.
 * A: filter with two conditions: name and salary
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        List<Employee> result = employees.stream()
                .filter(e -> e.getName().toLowerCase().contains("a") && e.getSalary() > 55000)
                .collect(Collectors.toList());
        System.out.println("43. Name contains 'a' and salary>55k: " + result);
    }
}
