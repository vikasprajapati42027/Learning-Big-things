package Test_java_leanring.test54;

/** test54 - Runnable */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test54: Runnable ===");
        Runnable r = () -> System.out.println("Running");
        r.run();
    }
}
