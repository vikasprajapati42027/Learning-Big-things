package Test_java_leanring.test133;

import java.util.function.Function;
import java.util.function.Predicate;

/** test133 - Function, Predicate */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test133: Function Predicate ===");
        Function<String, Integer> len = String::length;
        Predicate<String> shortStr = s -> s.length() < 4;
        System.out.println(len.apply("hello") + " " + shortStr.test("hi"));
    }
}
