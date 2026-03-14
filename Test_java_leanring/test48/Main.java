package Test_java_leanring.test48;

import java.util.function.Consumer;

/** test48 - Lambda */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test48: Lambda ===");
        Consumer<String> c = s -> System.out.println("Got: " + s);
        c.accept("hello");
    }
}
