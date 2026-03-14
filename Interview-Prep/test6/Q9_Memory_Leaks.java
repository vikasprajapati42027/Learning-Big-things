/**
 * Interviewer: Can Java have memory leaks?
 * Candidate: Yes, if objects are still referenced but no longer used (e.g., static collections, unclosed resources).
 */
import java.util.*;
public class Q9_Memory_Leaks {
    private static List<Object> leak = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Leak: Holding references in static fields forever.");
    }
}
