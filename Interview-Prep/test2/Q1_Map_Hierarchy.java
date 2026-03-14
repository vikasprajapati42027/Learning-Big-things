/**
 * INTERVIEWER: Explain the Map hierarchy and performance differences.
 * 
 * CANDIDATE: Map is not a subtype of Collection. It maps keys to values. 
 * The main implementations are HashMap, LinkedHashMap, and TreeMap.
 * 
 * PROPER EXPLANATION:
 * 1. HashMap: Uses hashing. O(1) for put/get. Order is unpredictable.
 * 2. LinkedHashMap: Extends HashMap + Doubly Linked List. Maintains Insertion Order. 
 *    O(1) performance.
 * 3. TreeMap: Implements SortedMap. Uses Red-Black Tree. Maintains Natural Sorting of keys. 
 *    O(log n) performance.
 */

import java.util.*;

public class Q1_Map_Hierarchy {
    public static void main(String[] args) {
        // HashMap Demo
        Map<String, String> hash = new HashMap<>();
        hash.put("Z", "Last"); hash.put("A", "First");
        System.out.println("HashMap (No Order): " + hash.keySet());

        // LinkedHashMap Demo 
        Map<String, String> linked = new LinkedHashMap<>();
        linked.put("Z", "Last"); linked.put("A", "First");
        System.out.println("LinkedHashMap (Insertion Order): " + linked.keySet());

        // TreeMap Demo
        Map<String, String> tree = new TreeMap<>();
        tree.put("Z", "Last"); tree.put("A", "First");
        System.out.println("TreeMap (Sorted Order): " + tree.keySet());
    }
}
