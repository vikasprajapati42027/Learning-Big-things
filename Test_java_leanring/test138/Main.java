package Test_java_leanring.test138;

/** test138 - switch expression (Java 14) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test138: switch expression ===");
        int n = 1;
        String r = switch (n) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "other";
        };
        System.out.println(r);
    }
}
