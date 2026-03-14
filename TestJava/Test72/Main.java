package TestJava.Test72;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stack vs Heap Memory ===\n");

        // The JVM divides memory into two main areas: Stack and Heap.

        System.out.println("--- 1. The Stack ---");
        // Used for primitive variables (int, double, boolean) and method calls.
        // It is FAST, highly organized (LIFO - Last In, First Out).
        // Each thread gets its own isolated Stack!
        int x = 10; // Stored purely on the Stack
        System.out.println("Primitive 'x' created on the Stack.");

        System.out.println("\n--- 2. The Heap ---");
        // Used for ALL Objects and Arrays.
        // It is a large, shared pool of memory accessible by all threads.
        // Managed by the Garbage Collector (GC).
        
        // The REFERENCE 'myArray' is on the Stack. 
        // The ACTUAL DATA `[1,2,3]` is on the Heap!
        int[] myArray = new int[]{1, 2, 3}; 
        System.out.println("Array Data created on the Heap.");
        
        System.out.println("\n--- 3. What happens during a Method Call? ---");
        changeValue(x, myArray);
        
        System.out.println("\nAfter method returns:");
        System.out.println("Primitive 'x' (Passed by Value): " + x); // Still 10!
        System.out.println("Array[0] (Reference Passed by Value): " + myArray[0]); // Changed to 99!
    }

    private static void changeValue(int localX, int[] localArray) {
        System.out.println("Inside method...");
        // 'localX' is a brand new copy on the Stack! Changing it doesn't affect 'x' in main()
        localX = 500; 
        
        // 'localArray' is a copy of the Reference. But both references point to the SAME Heap Object!
        localArray[0] = 99; 
    }
}
