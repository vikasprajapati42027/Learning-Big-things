package java_version.Java8_version.lambda.test57;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Count employees per department from the list.
 * A: stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Long> count = data.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("57. Count by department: " + count);
    }
}
