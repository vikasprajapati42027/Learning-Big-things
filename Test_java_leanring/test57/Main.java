package Test_java_leanring.test57;

/** test57 - synchronized method */
public class Main {
    private static int count = 0;
    static synchronized void inc() { count++; }
    public static void main(String[] args) {
        System.out.println("=== test57: synchronized ===");
        inc();
        inc();
        System.out.println(count);
    }
}
