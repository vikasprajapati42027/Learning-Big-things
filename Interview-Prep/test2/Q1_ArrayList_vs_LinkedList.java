/**
 * Interviewer: Explain ArrayList vs LinkedList.
 * Candidate: ArrayList uses a dynamic array; best for searching (O(1)). 
 * LinkedList uses nodes; best for frequent add/remove at the start (O(1)).
 */
import java.util.*;
public class Q1_ArrayList_vs_LinkedList {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>(); // Best for GET
        List<String> ll = new LinkedList<>(); // Best for ADD/REMOVE at ends
    }
}
