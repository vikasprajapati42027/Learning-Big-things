package Test_java_leanring.test39;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** test39 - File reading */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test39: File read ===");
        Path p = Path.of("Test_java_leanring/test39/hello.txt");
        Files.writeString(p, "line1\nline2");
        List<String> lines = Files.readAllLines(p);
        System.out.println(lines);
    }
}
