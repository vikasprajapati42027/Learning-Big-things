/**
 * Interviewer: Heap vs Stack?
 * Candidate: Heap stores all objects, Stack stores local variables and method call frames.
 * 
 * Explanation:
 * 1. Heap: Shared memory, managed by GC, slow access.
 * 2. Stack: Thread-private, automatic cleanup, fast access (LIFO).
 */
public class Q2_Heap_vs_Stack {
    public static void main(String[] args) {
        Object obj = new Object(); // Object on Heap, reference on Stack
        int x = 10; // Primitive on Stack
        System.out.println("Allocation: obj (Heap/Stack), x (Stack)");
    }
}
