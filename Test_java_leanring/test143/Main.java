package Test_java_leanring.test143;

/** test143 - var (local variable type inference, Java 10) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test143: var ===");
        var list = java.util.List.of(1, 2, 3);
        var s = "hello";
        System.out.println(list.size() + " " + s.length());
    }
}
