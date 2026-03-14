/**
 * Interview Prep: Test 2 - Collections
 * 10 Simple Examples with Explanation
 */

// 1. ArrayList vs LinkedList
// ArrayList is fast for searching (Get by index), LinkedList is fast for adding at the start.
import java.util.*;

class Q1 {
    void demo() {
        List<String> list = new ArrayList<>(); // Simple Array-based
        list.add("Java");
    }
}

// 2. HashMap Internals
// It uses Key-Value pairs. It uses hashCode() to find the bucket index.
class Q2 {
    void demo() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Vikas"); // Stores at index based on Hash
    }
}

// 3. Set vs List
// List allows duplicates [1,1,2]. Set removes them [1,2].
class Q3 {
    void demo() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 1, 2));
        System.out.println(set.size()); // Result: 2
    }
}

// 4. Comparable (Natural Sorting)
// Implementing this in the class itself to allow sorting.
class Student implements Comparable<Student> {
    int id;
    public int compareTo(Student other) { return this.id - other.id; }
}

// 5. Comparator (Custom Sorting)
// Define sorting logic outside the class.
class Q5 {
    void demo() {
        List<String> names = Arrays.asList("Vikas", "Dev");
        Collections.sort(names, (a, b) -> a.length() - b.length());
    }
}

// 6. PriorityQueue (Sorting on the fly)
// Always keeps the smallest (or largest) element at the top.
class Q6 {
    void demo() {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(10); pq.add(5);
        System.out.println(pq.peek()); // Result: 5
    }
}

// 7. Fail-Fast (ArrayList)
// Throws exception if you modify a list while looping through it.
class Q7 {
    void demo() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B"));
        for(String s : list) {
            // list.add("C"); // This would throw ConcurrentModificationException
        }
    }
}

// 8. Fail-Safe (CopyOnWriteArrayList)
// Safe to modify during loop because it works on a copy.
import java.util.concurrent.*;
class Q8 {
    void demo() {
        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("A"));
        for(String s : list) { list.add("B"); } // Safe!
    }
}

// 9. Iterator vs For-Each
// Iterator allows you to REMOVE elements while looping, for-each does not.
class Q9 {
    void demo(List<String> list) {
        Iterator<String> it = list.iterator();
        while(it.hasNext()) { if(it.next().equals("X")) it.remove(); }
    }
}

// 10. LinkedHashMap (Order preservation)
// Maintains the order in which you inserted the keys.
class Q10 {
    void demo() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "three"); map.put(1, "one");
        System.out.println(map.keySet()); // Result: [3, 1]
    }
}

public class QUESTIONS {
    public static void main(String[] args) {
        System.out.println("10 Collections Interview Questions with Code Ready.");
    }
}
