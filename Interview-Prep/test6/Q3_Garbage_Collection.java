/**
 * Interviewer: How does Garbage Collection work in Java?
 * Candidate: GC automatically manages memory by reclaiming space from objects that are no longer reachable from "GC Roots".
 *
 * Explanation:
 * 1. Mark and Sweep: The most basic algorithm. Marks reachable objects and sweeps others.
 * 2. Generations: Heap is split into Young and Old. Most objects die young (Minor GC).
 * 3. Compaction: Avoiding memory fragmentation by moving objects together.
 */
public class Q3_Garbage_Collection {
    public static void main(String[] args) {
        System.out.println("Initiating GC mechanism simulation...");
        Object obj = new Object();
        obj = null; // Object is now eligible for GC
        System.gc(); // Suggesting JVM to run GC
        System.out.println("GC root traversal and memory reclamation completed.");
    }
}
