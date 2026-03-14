package java_version.Java8_version.lambda.test37;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Sort employees by department then by salary descending.
 * A: sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary, Comparator.reverseOrder()))
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("37. Sorted by dept then salary desc: " + sorted);
    }
}
