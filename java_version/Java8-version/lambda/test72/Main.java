package java_version.Java8_version.lambda.test72;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get top 3 employees by salary from the list.
 * A: sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> top3 = data.getEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("72. Top 3 by salary: " + top3);
    }
}
