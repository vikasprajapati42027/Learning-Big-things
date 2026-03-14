package Test_java_leanring.test142;

/** test142 - pattern matching switch (Java 21) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test142: pattern switch ===");
        Object o = 42;
        String r = switch (o) {
            case Integer i -> "int " + i;
            case String s -> "str " + s;
            default -> "other";
        };
        System.out.println(r);
    }
}
