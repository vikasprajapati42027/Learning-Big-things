package java_version.Java8_version.lambda.test53;

import java_version.Java8_version.lambda.model.Department;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Filter departments by location (e.g. "Building-A") from model list.
 * A: getDepartmentList().stream().filter(d -> "Building-A".equals(d.getLocation())).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Department> inA = data.getDepartmentList().stream()
                .filter(d -> "Building-A".equals(d.getLocation()))
                .collect(Collectors.toList());
        System.out.println("53. Departments in Building-A: " + inA);
    }
}
