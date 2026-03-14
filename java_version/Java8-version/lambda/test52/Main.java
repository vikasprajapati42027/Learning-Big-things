package java_version.Java8_version.lambda.test52;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: From employee list in model, filter employees with salary greater than 60000.
 * A: getEmployeeList().stream().filter(e -> e.getSalary() > 60000).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> highSal = data.getEmployeeList().stream()
                .filter(e -> e.getSalary() > 60000)
                .collect(Collectors.toList());
        System.out.println("52. Filter salary > 60k: " + highSal);
    }
}
