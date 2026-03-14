/**
 * Interviewer: What are the main GC Algorithms?
 * Candidate: Serial, Parallel, G1, and ZGC.
 * 
 * Explanation:
 * 1. G1 (Garbage First): Default in Java 9+. Splits heap into regions.
 * 2. ZGC: Ultra-low latency GC (pause times < 1ms).
 * 3. Stop-the-world: When the JVM pauses all application threads to perform GC.
 */
public class Q4_Garbage_Collection {
    public static void main(String[] args) {
        System.out.println("GC Algorithms used to reclaim memory from unreachable objects.");
        // Hinting to JVM to run GC (Not guaranteed)
        System.gc();
        System.out.println("Requested Garbage Collection.");
    }
}
