package java_version.Java8_version.lambda.test80;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

/**
 * Q: Get summary statistics (count, sum, min, max, average) for student marks.
 * A: mapToInt(Student::getMarks).summaryStatistics() or collect(Collectors.summarizingInt(Student::getMarks)).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        IntSummaryStatistics stats = data.getStudentList().stream()
                .collect(Collectors.summarizingInt(Student::getMarks));
        System.out.println("80. Marks stats: count=" + stats.getCount() + " sum=" + stats.getSum() + " avg=" + stats.getAverage());
    }
}
