/**
 * Interviewer: How is the Heap organized?
 * Candidate: It's divided into Young Generation and Old Generation.
 * 
 * Explanation:
 * 1. Young Gen: Divided into Eden, Survivor 0, and Survivor 1. Small and collected frequently (Minor GC).
 * 2. Old Gen: Stores long-lived objects. Collected less frequently (Major GC).
 * 3. GC Priority: Most objects are born in Eden and die young.
 */
public class Q2_Heap_Memory {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Heap Memory Stats (MB):");
        System.out.println("Max Memory: " + (runtime.maxMemory() / 1024 / 1024));
        System.out.println("Total Allocated: " + (runtime.totalMemory() / 1024 / 1024));
        System.out.println("Free Memory: " + (runtime.freeMemory() / 1024 / 1024));
    }
}
