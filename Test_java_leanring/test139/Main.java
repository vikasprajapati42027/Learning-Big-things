package Test_java_leanring.test139;

/** test139 - yield in switch (Java 14) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test139: yield ===");
        int x = switch ("a") {
            case "a" -> { yield 1; }
            default -> 0;
        };
        System.out.println(x);
    }
}
