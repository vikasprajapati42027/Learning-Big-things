package TestJava.Test129;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class BigDataBlock {
    int[] data = new int[500_000]; // About 2MB
    String name;
    public BigDataBlock(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== WeakReference vs SoftReference ===\n");

        System.out.println("A normal variable holds a 'Strong' reference. Object is never GC'd.");
        
        // 1. WeakReference
        // An object weakly referenced will be destroyed on the VERY NEXT Garbage Collection cycle
        // if no strong references point to it. (Often used for tracking objects without pinning them).
        WeakReference<BigDataBlock> weakRef = new WeakReference<>(new BigDataBlock("Weak_Data"));
        
        // 2. SoftReference
        // An object softly referenced is kept alive AS LONG AS POSSIBLE! The GC only destroys 
        // it if the JVM is dangerously close to an OutOfMemoryError. (Used heavily for Caching!)
        SoftReference<BigDataBlock> softRef = new SoftReference<>(new BigDataBlock("Soft_Data"));

        System.out.println("Before GC:");
        System.out.println("WeakRef points to: " + weakRef.get());
        System.out.println("SoftRef points to: " + softRef.get());

        System.out.println("\n--- Triggering minor Garbage Collection ---");
        System.gc(); // Suggests GC
        Thread.sleep(1000);

        System.out.println("\nAfter GC:");
        System.out.println("WeakRef points to: " + weakRef.get()); // Likely null now! GC eagerly collected it.
        System.out.println("SoftRef points to: " + softRef.get()); // Still alive! JVM has plenty of memory.
        
        System.out.println("\nTo kill the SoftRef, we would need to allocate gigabytes of RAM to force memory pressure!");
    }
}
