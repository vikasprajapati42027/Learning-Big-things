/**
 * Interviewer: Why is ConcurrentHashMap better than Hashtable?
 * Candidate: Hashtable locks the WHOLE map. ConcurrentHashMap locks only the SPECIFIC bucket (segment).
 */
import java.util.concurrent.ConcurrentHashMap;
public class Q6_ConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Safe", "Thread");
    }
}
