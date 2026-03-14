/**
 * Interviewer: How does HashMap work?
 * Candidate: It uses Hashing. It calculates hashCode() to find a bucket. 
 * Collisions are handled via Linked Lists or Balanced Trees (Java 8+).
 */
import java.util.HashMap;
public class Q2_HashMap_Internals {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Interview", 100);
    }
}
