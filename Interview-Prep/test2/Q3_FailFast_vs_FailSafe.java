/**
 * Interviewer: What is Fail-Fast?
 * Candidate: Iterators that throw ConcurrentModificationException if the collection is modified while looping.
 */
import java.util.*;
import java.util.concurrent.*;
public class Q3_FailFast_vs_FailSafe {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>(); // Fail-Safe
        list.add("Safe");
        for(String s : list) list.add("Update"); // No error
    }
}
