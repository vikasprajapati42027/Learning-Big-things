package java_version.Java8_version.lambda.test96;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.stream.Collectors;

/**
 * Q: Check if all employees have salary > 50000 (allMatch).
 * A: stream().allMatch(e -> e.getSalary() > 50000).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        boolean all = data.getEmployeeList().stream().allMatch(e -> e.getSalary() > 50000);
        System.out.println("96. All salary > 50k: " + all);
    }
}
