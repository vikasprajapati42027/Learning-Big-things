package Test_java_leanring.test55;

/** test55 - Thread start */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== test55: Thread ===");
        Thread t = new Thread(() -> System.out.println("Thread run"));
        t.start();
        t.join();
    }
}
