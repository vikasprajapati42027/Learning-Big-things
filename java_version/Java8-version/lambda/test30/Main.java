package java_version.Java8_version.lambda.test30;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Comparator;
import java.util.Optional;

/**
 * Q: Find the employee with highest salary. How do you find second highest salary?
 * A: max(Comparator.comparing(Employee::getSalary)). Second: sort reverse, skip(1), findFirst.
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Optional<Employee> maxSal = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("30. Max salary employee: " + maxSal.map(Employee::toString).orElse("none"));

        Optional<Employee> secondMax = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        System.out.println("   Second highest salary: " + secondMax.map(Employee::toString).orElse("none"));
    }
}
