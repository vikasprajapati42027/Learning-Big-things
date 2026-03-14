/**
 * Interviewer: Comparable vs Comparator?
 * Candidate: Comparable for natural order (inside class). 
 * Comparator for custom order (outside class).
 */
import java.util.*;
public class Q4_Comparable_vs_Comparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("B", "A");
        Collections.sort(list); // Comparable natural order
        Collections.sort(list, (a, b) -> b.compareTo(a)); // Comparator custom order
    }
}
