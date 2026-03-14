package Test_java_leanring.test108;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** test108 - ExecutorService */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test108: ExecutorService ===");
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> System.out.println("task"));
        es.shutdown();
        es.awaitTermination(1, TimeUnit.SECONDS);
    }
}
