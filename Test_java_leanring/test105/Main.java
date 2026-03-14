package Test_java_leanring.test105;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/** test105 - Charset */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test105: Charset ===");
        byte[] b = "hi".getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(b, Charset.defaultCharset()));
    }
}
