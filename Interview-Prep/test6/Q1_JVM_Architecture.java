/**
 * Interviewer: Explain JVM Architecture.
 * Candidate: JVM consists of ClassLoader, Runtime Data Areas, and Execution Engine.
 * 
 * Explanation:
 * 1. ClassLoader: Responsible for loading .class files. It uses three phases: Load, Link, Initialize.
 * 2. Memory Area (Runtime Data): 
 *    - Heap: Shared, stores objects. 
 *    - Stack: Thread-private, stores method frames and local variables.
 *    - Metaspace: Stores class metadata.
 * 3. Execution Engine: Uses Interpreter and JIT Compiler to convert bytecode to machine code.
 */
public class Q1_JVM_Architecture {
    public static void main(String[] args) {
        System.out.println("JVM Subsystems:");
        System.out.println("- ClassLoader Subsystem");
        System.out.println("- Runtime Data Areas (Heap, Stack, PC, Native)");
        System.out.println("- Execution Engine (JIT, GC)");
        
        // Demonstration: Checking ClassLoader
        System.out.println("\nClass Loader for this class: " + Q1_JVM_Architecture.class.getClassLoader());
        System.out.println("Class Loader for String class (Bootstrap): " + String.class.getClassLoader());
    }
}
