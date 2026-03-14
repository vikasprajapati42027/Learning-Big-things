package java_version.Java8_version.lambda.test34;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Q: Find the highest-paid employee in each department.
 * A: groupingBy + collectingAndThen(maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Optional<Employee>> maxByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("34. Max salary per department:");
        maxByDept.forEach((dept, opt) -> System.out.println("   " + dept + ": " + opt.map(Employee::toString).orElse("none")));
    }
}
