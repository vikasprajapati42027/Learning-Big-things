package Test_java_leanring.test13;

/** test13 - final: variable cannot be reassigned */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test13: final ===");
        final int x = 5;
        final String s = "hello";
        System.out.println(x + " " + s);
    }
}
