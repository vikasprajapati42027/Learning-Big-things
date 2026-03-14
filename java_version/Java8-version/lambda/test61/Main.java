package java_version.Java8_version.lambda.test61;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modify list in place – give 10% raise using setter. Then replace model list with modified.
 * A: forEach(e -> e.setSalary(e.getSalary() * 1.1)) on same list, or collect and data.setEmployeeList(newList).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> list = data.getEmployeeList();
        list.forEach(e -> e.setSalary(e.getSalary() * 1.1));
        System.out.println("61. In-place 10% raise: " + list);
    }
}
