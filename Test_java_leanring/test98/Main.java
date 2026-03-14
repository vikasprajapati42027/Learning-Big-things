package Test_java_leanring.test98;

import java.nio.file.Path;
import java.nio.file.Paths;

/** test98 - Path, Paths */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test98: Path ===");
        Path p = Paths.get("a", "b", "c.txt");
        System.out.println(p.getFileName());
    }
}
