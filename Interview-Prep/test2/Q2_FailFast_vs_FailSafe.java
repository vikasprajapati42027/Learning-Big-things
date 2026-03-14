/**
 * INTERVIEWER: What is the difference between Fail-Fast and Fail-Safe iterators?
 * 
 * CANDIDATE: Fail-fast iterators throw an exception if the collection is modified 
 * during iteration. Fail-safe iterators allow modification.
 * 
 * PROPER EXPLANATION:
 * 1. Fail-Fast (Default): Uses a 'modCount'. If changed, throws ConcurrentModificationException.
 *    Used by ArrayList, HashMap, etc.
 * 2. Fail-Safe: Actually operates on a snapshot (Copy-on-Write) or view of the data. 
 *    Used by CopyOnWriteArrayList, ConcurrentHashMap.
 */

import java.util.*;
import java.util.concurrent.*;

public class Q2_FailFast_vs_FailSafe {
    public static void main(String[] args) {
        // FAIL-FAST EXAMPLE
        List<String> list1 = new ArrayList<>(Arrays.asList("Java", "Spring"));
        try {
            for (String s : list1) {
                if (s.equals("Java")) list1.remove(s); // MODIFICATION
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast: Caught ConcurrentModificationException");
        }

        // FAIL-SAFE EXAMPLE
        List<String> list2 = new CopyOnWriteArrayList<>(Arrays.asList("Docker", "K8s"));
        for (String s : list2) {
            if (s.equals("Docker")) list2.add("AWS"); // SAFE MODIFICATION
        }
        System.out.println("Fail-Safe Result: " + list2);
    }
}
