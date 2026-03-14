package java_version.Java8_version.lambda.test38;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Optional;

/**
 * Q: How would you find the first employee in "IT" department? Handle no match.
 * A: filter + findFirst() returns Optional<Employee>; use orElse(null) or ifPresent()
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Optional<Employee> firstIT = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .findFirst();
        System.out.println("38. First IT employee: " + firstIT.map(Employee::toString).orElse("none"));

        Optional<Employee> notFound = employees.stream()
                .filter(e -> "Legal".equals(e.getDepartment()))
                .findFirst();
        System.out.println("   First Legal (none): " + notFound.orElse(null));
    }
}
