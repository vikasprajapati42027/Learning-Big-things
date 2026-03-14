package Test_java_leanring.test122;

import java.text.NumberFormat;
import java.util.Locale;

/** test122 - NumberFormat */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test122: NumberFormat ===");
        System.out.println(NumberFormat.getNumberInstance(Locale.US).format(1234.56));
    }
}
