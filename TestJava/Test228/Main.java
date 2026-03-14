package TestJava.Test228;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 228: Garbage Collector Tuning Concept ===\n");

        System.out.println("Java offers several GCs designed for different workloads.");
        System.out.println("In Java 8, Parallel GC was default. Since Java 9+, G1GC is default.\n");

        System.out.println("--- 1. Parallel GC (Throughput) ---");
        System.out.println("Flag: -XX:+UseParallelGC");
        System.out.println("Best for: Batch jobs, AI training, background processors.");
        System.out.println("Behavior: Stops the world entirely, uses all CPU cores to clean up as fast as possible.");
        System.out.println("Pros: Maximum overall CPU efficiency. Cons: Long pause times (bad for UI/Web APIs).\n");

        System.out.println("--- 2. G1 GC (Low Latency / Balanced) ---");
        System.out.println("Flag: -XX:+UseG1GC");
        System.out.println("Best for: General purpose, Web Servers (Spring Boot).");
        System.out.println("Behavior: Divides heap into regions. Cleans up regions with the most garbage first concurrently.");
        System.out.println("Pros: Predictable pause times (-XX:MaxGCPauseMillis=200). Cons: Uses slightly more memory.\n");

        System.out.println("--- 3. ZGC (Ultra-Low Latency) ---");
        System.out.println("Flag: -XX:+UseZGC");
        System.out.println("Best for: High frequency trading, massive heaps (TBs!), ultra-responsive apps.");
        System.out.println("Behavior: Does almost all work concurrently while app is running using colored pointers.");
        System.out.println("Pros: Pauses are typically < 1 millisecond! Cons: Lower overall throughput than Parallel.\n");

        System.out.println("--- Memory Leak Simulation ---");
        System.out.println("Generating garbage to trigger a GC... (You can monitor this with VisualVM)");
        
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < 500_000; i++) {
            objects.add(new byte[1024]); // Allocate 1KB array
            if (i % 100_000 == 0) {
                System.out.println("Allocated " + (i / 1000) + " MB...");
                // Remove most of them so they become unreachable 'Garbage'
                objects.clear(); 
            }
        }
        System.out.println("Test complete. The GC will clean up the unreferenced byte arrays in the background.");
    }
}
