package Test_java_leanring.test120;

/** test120 - Text block (Java 15) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test120: Text block ===");
        String s = """
                line1
                line2
                """;
        System.out.println(s.trim());
    }
}
