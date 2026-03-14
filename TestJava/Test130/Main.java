package TestJava.Test130;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

class Resource {
    String name;
    public Resource(String name) { this.name = name; }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== PhantomReference & ReferenceQueue ===\n");

        // PhantomReferences are the weakest of all.
        // You CANNOT ever retrieve the object using .get() (it always returns null).
        // It is ONLY used to get a notification WHEN an object has been destroyed by GC!
        // This is a safer, non-resurrecting alternative to overriding finalize()!

        ReferenceQueue<Resource> queue = new ReferenceQueue<>();
        
        // Strong reference
        Resource res = new Resource("Heavy Database Connection");
        
        // Attach the Phantom to the Queue
        PhantomReference<Resource> phantom = new PhantomReference<>(res, queue);

        System.out.println("Is PhantomRef object accessible? " + phantom.get()); // null!

        // Clear the strong reference
        res = null;

        System.out.println("\nChecking queue before GC: " + queue.poll()); // null, object is still implicitly alive

        System.out.println("\n--- Triggering GC to destroy the object! ---");
        System.gc();
        Thread.sleep(1000); // Give GC time
        
        // Force evaluation of references (some JVM wrappers need this memory allocation to trigger queue population)
        ArrayList<Object> memoryPressure = new ArrayList<>();
        for(int i=0; i<10000; i++) memoryPressure.add(new Object());

        // Now we check the queue
        Reference<? extends Resource> destroyedRef = queue.poll();
        
        if (destroyedRef != null) {
            System.out.println("\n[ALERT] ReferenceQueue received the PhantomReference!");
            System.out.println("This means the 'Heavy Database Connection' object has been COMPLETELY removed from RAM.");
            System.out.println("We can now safely do manual cleanup of physical resources here.");
            
            // Clean up the phantom
            destroyedRef.clear();
        } else {
            System.out.println("\nGC didn't enqueue it yet. Sometimes JVM takes its time.");
        }
    }
}
