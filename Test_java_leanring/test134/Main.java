package Test_java_leanring.test134;

import java.util.function.Supplier;
import java.util.function.BiFunction;

/** test134 - Supplier, BiFunction */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test134: Supplier BiFunction ===");
        Supplier<Double> random = Math::random;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        System.out.println(add.apply(2, 3));
    }
}
