package Java8_version;

import java.util.function.IntBinaryOperator;

/** Java 8 - Lambda with custom @FunctionalInterface. */
public class Calculator {
    @FunctionalInterface
    interface Operation {
        int apply(int a, int b);
    }

    public static void main(String[] args) {
        Operation add = (a, b) -> a + b;
        Operation mul = (x, y) -> x * y;
        System.out.println("add: " + add.apply(3, 5));
        System.out.println("mul: " + mul.apply(3, 5));

        IntBinaryOperator sub = (a, b) -> a - b;
        System.out.println("sub: " + sub.applyAsInt(10, 3));
    }
}
