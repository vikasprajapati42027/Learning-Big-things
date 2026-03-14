package Test_java_leanring.test102;

import java.io.PrintWriter;
import java.io.StringWriter;

/** test102 - PrintWriter */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test102: PrintWriter ===");
        StringWriter sw = new StringWriter();
        new PrintWriter(sw).println("hi");
        System.out.println(sw.toString().trim());
    }
}
