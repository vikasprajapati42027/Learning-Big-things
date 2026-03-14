/**
 * Interviewer: What is IdentityHashMap?
 * Candidate: It uses reference equality (==) instead of equals() to compare keys.
 */
import java.util.IdentityHashMap;
public class Q10_IdentityHashMap {
    public static void main(String[] args) {
        String s1 = new String("A");
        String s2 = new String("A");
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        map.put(s1, "Val1");
        map.put(s2, "Val2");
        System.out.println(map.size()); // 2 (s1 != s2 by reference)
    }
}
