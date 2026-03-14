package java_version.Java8_version.lambda.test68;

import java_version.Java8_version.lambda.model.Department;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modify department names to uppercase and collect to new list (setter: setName).
 * A: map(d -> { d.setName(d.getName().toUpperCase()); return d; }) or create new Department.
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Department> upper = data.getDepartmentList().stream()
                .map(d -> {
                    Department copy = new Department(d.getId(), d.getName().toUpperCase(), d.getLocation());
                    return copy;
                })
                .collect(Collectors.toList());
        System.out.println("68. Dept names uppercase: " + upper);
    }
}
