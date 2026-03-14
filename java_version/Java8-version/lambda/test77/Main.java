package java_version.Java8_version.lambda.test77;

import java_version.Java8_version.lambda.model.Department;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get distinct locations from department list (aggregation – unique values).
 * A: map(Department::getLocation).distinct().collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<String> locations = data.getDepartmentList().stream()
                .map(Department::getLocation)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("77. Distinct locations: " + locations);
    }
}
