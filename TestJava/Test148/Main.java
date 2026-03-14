package TestJava.Test148;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Garbage Collection & JVM Tuning Concepts ===\n");

        System.out.println("Java has several Garbage Collectors. The modern default (Java 9+) is G1GC.");
        System.out.println("Java 11+ introduced ZGC and Shenandoah for ultra-low latency (pause times < 1ms)!\n");

        System.out.println("--- Common JVM Flags ---");
        System.out.println("-Xms2g : Set initial heap size to 2 Gigabytes");
        System.out.println("-Xmx4g : Set maximum heap size to 4 Gigabytes");
        System.out.println("-XX:+UseZGC : Use the ultra-low latency Z Garbage Collector (Java 15+ default ready)");
        System.out.println("-XX:+UseG1GC : Use the G1 Garbage Collector (Good balance of throughput/latency)\n");

        System.out.println("--- Generating Memory Pressure ---");
        System.out.println("We will now allocate objects rapidly to trigger the Garbage Collector...");
        
        // We use a separate thread so we can interrupt it later easily
        Thread memoryEater = new Thread(() -> {
            List<byte[]> memoryHog = new ArrayList<>();
            try {
                int count = 0;
                while (true) {
                    // Allocate 1MB of memory
                    memoryHog.add(new byte[1024 * 1024]);
                    count++;
                    
                    if (count % 50 == 0) {
                        System.out.println("Allocated " + count + " MB...");
                        // Clear the list to allow the GC to actually collect the memory!
                        // If we didn't clear this, we would get an OutOfMemoryError.
                        memoryHog.clear(); 
                        Thread.sleep(100); 
                    }
                }
            } catch (InterruptedException | OutOfMemoryError e) {
                System.out.println("\nMemory generation stopped: " + e.getClass().getSimpleName());
            }
        });

        memoryEater.start();
        
        // Let it run for 2 seconds to generate GC activity
        Thread.sleep(2000); 
        memoryEater.interrupt();
        
        System.out.println("\nIn a real-world scenario, you would monitor this GC activity using:");
        System.out.println("1. VisualVM");
        System.out.println("2. JVM Flag: -Xlog:gc* (Logs garbage collection details to the console)");
    }
}
