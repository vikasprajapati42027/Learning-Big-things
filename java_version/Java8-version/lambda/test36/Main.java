package java_version.Java8_version.lambda.test36;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Partition employees into high salary (>=60000) and low salary.
 * A: Collectors.partitioningBy(e -> e.getSalary() >= 60000)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() >= 60000));
        System.out.println("36. High salary (>=60k): " + partitioned.get(true));
        System.out.println("   Low salary: " + partitioned.get(false));
    }
}
