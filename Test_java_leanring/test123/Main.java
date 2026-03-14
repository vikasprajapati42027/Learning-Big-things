package Test_java_leanring.test123;

import java.util.ResourceBundle;

/** test123 - ResourceBundle (use default if no props file) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test123: ResourceBundle ===");
        ResourceBundle rb = ResourceBundle.getBundle("Test_java_leanring.test123.test123", java.util.Locale.ROOT);
        System.out.println(rb.getString("key"));
    }
}
