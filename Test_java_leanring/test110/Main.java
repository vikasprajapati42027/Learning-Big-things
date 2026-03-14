package Test_java_leanring.test110;

import java.util.concurrent.CompletableFuture;

/** test110 - CompletableFuture */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test110: CompletableFuture ===");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "done");
        System.out.println(cf.get());
    }
}
