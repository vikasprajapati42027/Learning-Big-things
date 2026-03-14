package java_version.Java8_version.lambda.test98;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modification – increase age by 1 for all employees. New list using setter in map.
 * A: map(e -> { Employee c = new Employee(...); c.setAge(e.getAge()+1); return c; }) or create with getAge()+1.
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> result = data.getEmployeeList().stream()
                .map(e -> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary(), e.getAge() + 1))
                .collect(Collectors.toList());
        System.out.println("98. Age +1: " + result);
    }
}
