/**
 * Interviewer: Why use TreeSet over HashSet?
 * Candidate: HashSet is faster (O(1)), but TreeSet keeps elements Sorted (O(log n)).
 */
import java.util.*;
public class Q5_HashSet_vs_TreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(); // Elements will be sorted automatically
        set.add(10); set.add(5);
        System.out.println(set); // [5, 10]
    }
}
