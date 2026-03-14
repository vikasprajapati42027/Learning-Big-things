package java_version.Java8_version.lambda.test45;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Q: Which department has the most employees? Get department name.
 * A: groupingBy + counting, then entrySet().stream().max(Comparator.comparingByValue())
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Optional<Map.Entry<String, Long>> maxEntry = countByDept.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("45. Department with most employees: " + maxEntry.map(e -> e.getKey() + " (" + e.getValue() + ")").orElse("none"));
    }
}
