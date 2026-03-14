package TestJava.Test222;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 222: ManagementFactory (JVM Stats) ===\n");

        System.out.println("Java provides extensive MXBeans to query the OS and JVM Memory.\n");

        // 1. OS Stats
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("--- Operating System ---");
        System.out.println("OS Name: " + osBean.getName());
        System.out.println("Architecture: " + osBean.getArch());
        System.out.println("Available Processors (Cores): " + osBean.getAvailableProcessors());
        System.out.println("System Load Average: " + osBean.getSystemLoadAverage());

        // 2. Runtime Stats
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("\n--- JVM Runtime ---");
        System.out.println("JVM Name: " + runtimeBean.getVmName());
        System.out.println("JVM Vendor: " + runtimeBean.getVmVendor());
        // Getting JVM Start Time and Uptime
        long uptimeStr = runtimeBean.getUptime();
        System.out.println("JVM Uptime: " + uptimeStr + " ms");

        // 3. Memory Stats (Heap & Non-Heap)
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeapUsage = memBean.getNonHeapMemoryUsage();
        
        System.out.println("\n--- Memory Usage ---");
        System.out.println("Heap Initial: " + formatBytes(heapUsage.getInit()));
        System.out.println("Heap Used   : " + formatBytes(heapUsage.getUsed()));
        System.out.println("Heap Max    : " + formatBytes(heapUsage.getMax()));
        System.out.println("Non-Heap Used (Metaspace, etc): " + formatBytes(nonHeapUsage.getUsed()));
    }

    private static String formatBytes(long bytes) {
        if (bytes == -1) return "Unlimited";
        return (bytes / 1024 / 1024) + " MB";
    }
}
