package java_version.Java8_version.lambda.test91;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/** Q: Names of employees in IT. A: filter(IT).map(Employee::getName).collect(toList()). */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<String> names = data.getEmployeeList().stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("91. IT names: " + names);
    }
}
