package java_version.Java8_version.lambda.test67;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Partition employee list into IT and non-IT. Store as two lists or use partitioningBy.
 * A: collect(Collectors.partitioningBy(e -> "IT".equals(e.getDepartment()))).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<Boolean, List<Employee>> partition = data.getEmployeeList().stream()
                .collect(Collectors.partitioningBy(e -> "IT".equals(e.getDepartment())));
        System.out.println("67. IT: " + partition.get(true) + " | Others: " + partition.get(false));
    }
}
