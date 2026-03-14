package java_version.Java8_version.lambda.test93;

import java_version.Java8_version.lambda.model.Department;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Filter departments and modify – set location to "Main" for all. New list.
 * A: map(d -> new Department(d.getId(), d.getName(), "Main")).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Department> updated = data.getDepartmentList().stream()
                .map(d -> new Department(d.getId(), d.getName(), "Main"))
                .collect(Collectors.toList());
        System.out.println("93. All location=Main: " + updated);
    }
}
