package Test_java_leanring.test104;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;

/** test104 - StringReader, StringWriter */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("=== test104: StringReader/Writer ===");
        StringWriter w = new StringWriter();
        w.write("test");
        StringReader r = new StringReader(w.toString());
        char[] c = new char[4];
        r.read(c);
        System.out.println(new String(c));
    }
}
