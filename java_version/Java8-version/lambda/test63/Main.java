package java_version.Java8_version.lambda.test63;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Comparator;
import java.util.Optional;

/**
 * Q: From employee list, find max salary. Use getter.
 * A: stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Optional<Double> maxSal = data.getEmployeeList().stream()
                .map(Employee::getSalary)
                .max(Double::compareTo);
        System.out.println("63. Max salary: " + maxSal.orElse(0.0));
    }
}
