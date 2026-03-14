package Test_java_leanring.test103;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/** test103 - ByteArrayInputStream/OutputStream */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("=== test103: ByteArray streams ===");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(65);
        byte[] b = out.toByteArray();
        System.out.println(new ByteArrayInputStream(b).read());
    }
}
