package Test_java_leanring.test135;

import java.util.List;
import java.util.stream.IntStream;

/** test135 - IntStream rangeClosed */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test135: IntStream rangeClosed ===");
        System.out.println(IntStream.rangeClosed(1, 5).sum());
    }
}
