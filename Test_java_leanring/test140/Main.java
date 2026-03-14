package Test_java_leanring.test140;

/** test140 - instanceof pattern (Java 16) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test140: instanceof pattern ===");
        Object o = "hello";
        if (o instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }
}
