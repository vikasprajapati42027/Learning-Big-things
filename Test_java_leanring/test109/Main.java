package Test_java_leanring.test109;

import java.util.concurrent.*;

/** test109 - Callable, Future */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test109: Callable Future ===");
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> f = es.submit(() -> 1 + 2);
        System.out.println(f.get());
        es.shutdown();
    }
}
