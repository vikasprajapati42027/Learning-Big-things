package Test_java_leanring.test100;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

/** test100 - BufferedReader */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("=== test100: BufferedReader ===");
        try (BufferedReader r = new BufferedReader(new StringReader("line1\nline2"))) {
            r.lines().forEach(System.out::println);
        }
    }
}
