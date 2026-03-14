package java_version.Java8_version.lambda.test19;

import java.util.*;
import java.util.stream.IntStream;

/** test19: IntStream summaryStatistics */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test19: SummaryStatistics ===\n");
        IntSummaryStatistics stats = IntStream.of(10, 5, 20, 8, 15).summaryStatistics();
        System.out.println("count: " + stats.getCount());
        System.out.println("sum: " + stats.getSum());
        System.out.println("min: " + stats.getMin());
        System.out.println("max: " + stats.getMax());
        System.out.println("average: " + stats.getAverage());
    }
}
