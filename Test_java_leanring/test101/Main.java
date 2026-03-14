package Test_java_leanring.test101;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.IOException;

/** test101 - BufferedWriter */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("=== test101: BufferedWriter ===");
        StringWriter sw = new StringWriter();
        try (BufferedWriter w = new BufferedWriter(sw)) {
            w.write("hello");
            w.newLine();
        }
        System.out.println(sw.toString());
    }
}
