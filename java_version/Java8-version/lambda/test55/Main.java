package java_version.Java8_version.lambda.test55;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Aggregation – total salary by department from employee list.
 * A: stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary))).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Double> totalByDept = data.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
        System.out.println("55. Total salary by department: " + totalByDept);
    }
}
