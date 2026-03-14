package java_version.Java8_version.lambda.test94;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Department with highest total salary (aggregation then max).
 * A: groupingBy + summingDouble, then entrySet().stream().max(comparingByValue()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Double> totalByDept = data.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
        String top = totalByDept.entrySet().stream()
                .max(Map.Entry.<String, Double>comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("none");
        System.out.println("94. Dept with max total salary: " + top);
    }
}
