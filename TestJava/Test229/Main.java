package TestJava.Test229;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

// An object that holds onto expensive native resources (like a C++ memory pointer or file handle)
class ExpensiveNativeResource {
    public int id;
    public ExpensiveNativeResource(int id) { this.id = id; }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("[WARNING] Finalize called. This is deprecated and dangerous!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 229: ReferenceQueue & PhantomReference ===\n");

        System.out.println("Before Java 9, people used finalize() to clean up C++ memory or File Handles");
        System.out.println("just before the GC destroyed the object. This caused massive performance issues");
        System.out.println("and sometimes resurrected dead objects (Finalizer attacks).\n");

        System.out.println("Solution: PhantomReferences and ReferenceQueues!\n");

        ReferenceQueue<ExpensiveNativeResource> queue = new ReferenceQueue<>();
        List<PhantomReference<ExpensiveNativeResource>> trackingList = new ArrayList<>();

        // 1. Create the Object
        ExpensiveNativeResource obj = new ExpensiveNativeResource(99);

        // 2. Wrap it in a PhantomReference and attach it to the Queue
        PhantomReference<ExpensiveNativeResource> phantom = new PhantomReference<>(obj, queue);
        trackingList.add(phantom);

        System.out.println("Object created. Phantom reference setup.");

        // 3. Nullify the strong reference so it becomes eligible for Garbage Collection
        obj = null;

        System.out.println("Object set to null. Forcing Garbage Collection...");
        
        // 4. Force GC
        System.gc();
        
        // Give GC a moment
        Thread.sleep(500);

        // 5. Check the queue! When the GC destroys the actual object, it places the PhantomReference in this queue!
        Reference<? extends ExpensiveNativeResource> referenceFromQueue = queue.poll();
        
        if (referenceFromQueue != null) {
            System.out.println("\n[SUCCESS] The GC destroyed the object, and notified our queue!");
            System.out.println("We can now safely free up the associated C++ memory or file handles!");
            
            // You can't get the object back (it's dead). referenceFromQueue.get() always returns null!
            System.out.println("Can we resurrect it? " + referenceFromQueue.get() + " (Good!)");
        } else {
            System.out.println("GC didn't run quite fast enough for this test, but the concept stands!");
        }
    }
}
