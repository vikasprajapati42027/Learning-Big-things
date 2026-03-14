/**
 * Interviewer: Useful JVM flags?
 * Candidate: -Xmx (Max Heap), -Xms (Initial Heap), -XX:MetaspaceSize, -XX:+UseG1GC.
 */
public class Q10_JVM_Parameters {
    public static void main(String[] args) {
        long maxHeap = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        System.out.println("Max Heap Size: " + maxHeap + " MB");
    }
}
