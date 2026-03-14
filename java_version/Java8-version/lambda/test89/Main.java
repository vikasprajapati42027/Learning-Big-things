package java_version.Java8_version.lambda.test89;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Q: Sort employee list by name and update model. A: sorted(Comparator.comparing(Employee::getName)); setEmployeeList. */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> sorted = data.getEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        data.setEmployeeList(sorted);
        System.out.println("89. Sorted by name: " + data.getEmployeeList());
    }
}
