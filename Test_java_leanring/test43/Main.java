package Test_java_leanring.test43;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** test43 - try-with-resources */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test43: try-with-resources ===");
        try (var s = Files.lines(Path.of("Test_java_leanring/test43/dummy.txt"))) {
            s.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("No file (expected): " + e.getMessage());
        }
    }
}
