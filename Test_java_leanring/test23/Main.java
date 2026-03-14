package Test_java_leanring.test23;

/** test23 - Enum basics */
enum Color { RED, GREEN, BLUE }

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test23: Enum ===");
        Color c = Color.RED;
        System.out.println(c + " " + c.ordinal());
    }
}
