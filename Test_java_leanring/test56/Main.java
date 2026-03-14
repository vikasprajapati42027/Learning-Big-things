package Test_java_leanring.test56;

/** test56 - Thread.sleep */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== test56: sleep ===");
        long before = System.currentTimeMillis();
        Thread.sleep(10);
        System.out.println("Slept " + (System.currentTimeMillis() - before) + " ms");
    }
}
