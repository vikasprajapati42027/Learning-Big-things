/**
 * Interviewer: PermGen vs Metaspace?
 * Candidate: PermGen was in the Heap (Fixed size). Metaspace (Java 8+) uses Native Memory (Dynamic).
 */
public class Q5_Metaspace {
    public static void main(String[] args) {
        System.out.println("Metaspace: Native memory for class metadata.");
    }
}
