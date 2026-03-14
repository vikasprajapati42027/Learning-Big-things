package TestJava.Test223;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 223: ThreadMXBean (Detecting Deadlocks) ===\n");

        System.out.println("Normally, a deadlock freezes your application forever. But with ThreadMXBean,");
        System.out.println("we can programmatically write a 'watchdog' thread to detect and report them!\n");

        Object lockA = new Object();
        Object lockB = new Object();

        // Thread 1: Locks A, waits for B
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (lockB) { System.out.println("T1 Finished."); }
            }
        });

        // Thread 2: Locks B, waits for A
        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (lockA) { System.out.println("T2 Finished."); }
            }
        });

        t1.start();
        t2.start();

        // Give them a moment to get stuck
        Thread.sleep(500);

        // --- The Deadlock Watchdog ---
        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
        
        long[] deadlockedThreadIds = tmx.findDeadlockedThreads();
        
        if (deadlockedThreadIds != null) {
            System.out.println("🚨 RED ALERT: DEADLOCK DETECTED! 🚨");
            System.out.println("The following threads are stuck infinitely:\n");
            
            ThreadInfo[] threadInfos = tmx.getThreadInfo(deadlockedThreadIds);
            for (ThreadInfo info : threadInfos) {
                System.out.println("Thread Name : " + info.getThreadName());
                System.out.println("Is waiting to lock: " + info.getLockName());
                System.out.println("Which is currently owned by Thread ID: " + info.getLockOwnerId());
                System.out.println("-".repeat(40));
            }
            
            System.out.println("\nBecause we detected it, we can gracefully alert monitoring systems!");
            System.exit(1); // Force exit since those threads are dead locked
        } else {
            System.out.println("No deadlocks found.");
        }
    }
}
