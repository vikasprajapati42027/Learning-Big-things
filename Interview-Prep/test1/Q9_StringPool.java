/**
 * INTERVIEWER: Why are Strings immutable and what is String Constant Pool?
 * 
 * CANDIDATE: String immutability means once created, its value cannot be changed. 
 * This allows Strings to be cached in the String Constant Pool to save memory.
 *
 * PROPER EXPLANATION:
 * 1. Memory Efficiency: Reusing same string literals (SCP).
 * 2. Security: Critical data like DB passwords won't change unexpectedly.
 * 3. Thread Safety: Safe to share across threads without synchronization.
 * 4. Literal create: Goes to SCP. 'new String()': Created in Heap + SCP check.
 */

public class Q9_StringPool {
    public static void main(String[] args) {
        // String Literals: go to Pool
        String s1 = "Hello";
        String s2 = "Hello"; 

        // New Object: goes to Heap
        String s3 = new String("Hello");

        System.out.println("Literal Check (s1 == s2): " + (s1 == s2)); // true
        System.out.println("Heap vs Pool Check (s1 == s3): " + (s1 == s3)); // false
        
        // intern(): manually moving/pointing to SCP
        String s4 = s3.intern(); 
        System.out.println("After intern() (s1 == s4): " + (s1 == s4)); // true
    }
}
