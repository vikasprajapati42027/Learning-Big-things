/**
 * Interviewer: Difference between OOM and StackOverflowError?
 * Candidate: OOM occurs when Heap is full. StackOverflow occurs when Stack is full (usually recursion).
 */
public class Q7_OutOfMemoryError {
    public static void main(String[] args) {
        // Example of causing StackOverflowError
        // recursiveCall();
    }
    static void recursiveCall() { recursiveCall(); }
}
