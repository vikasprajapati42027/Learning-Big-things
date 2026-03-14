package TestJava.Test47;

// ThreadLocal provides special variables that can only be read/written by the SAME thread.
// Even if multiple threads access the same ThreadLocal instance, they each get their own independent copy!
// Highly useful for maintaining state per-thread (like database connections or user sessions) without locking.
public class Main {
    
    // Each thread gets its own isolated instance of the data inside this ThreadLocal
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        System.out.println("=== ThreadLocal Variables Tutorial ===");

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            
            // Get the initial value (should answer 0 for every thread!)
            System.out.println(threadName + " Initial Value: " + threadLocalValue.get());

            // Modify the value
            threadLocalValue.set((int) (Math.random() * 100));

            try { Thread.sleep(500); } catch (InterruptedException e) {}

            // Print the modified value
            // Since it's ThreadLocal, NO OTHER THREAD could have overwritten this thread's value!
            System.out.println(threadName + " Modified Value: " + threadLocalValue.get());
            
            // Best Practice: Always remove the value when done to prevent memory leaks in thread pools
            threadLocalValue.remove();
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
