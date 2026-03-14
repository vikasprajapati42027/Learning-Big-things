package Test_java_leanring.test40;

import java.nio.file.Files;
import java.nio.file.Path;

/** test40 - File writing */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test40: File write ===");
        Path p = Path.of("Test_java_leanring/test40/out.txt");
        Files.writeString(p, "Hello from test40");
        System.out.println("Written: " + Files.readString(p));
    }
}
