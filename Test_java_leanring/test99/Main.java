package Test_java_leanring.test99;

import java.nio.file.Files;
import java.nio.file.Path;

/** test99 - Files.exists, createDirectories */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test99: Files ===");
        Path dir = Path.of("Test_java_leanring/test99/created");
        Files.createDirectories(dir);
        System.out.println(Files.exists(dir));
    }
}
