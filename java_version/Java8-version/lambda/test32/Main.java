package java_version.Java8_version.lambda.test32;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.stream.Collectors;

/**
 * Q: Join all employee names with comma and prefix/suffix.
 * A: map(Employee::getName).collect(Collectors.joining(", ", "[", "]"))
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        String joined = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("32. Joined names: " + joined);
    }
}
