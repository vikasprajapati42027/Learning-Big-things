/**
 * Interviewer: How to implement a simple LRU Cache?
 * Candidate: Use LinkedHashMap with accessOrder=true.
 */
import java.util.LinkedHashMap;
import java.util.Map;
public class Q8_LRU_Cache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity = 3;
    public Q8_LRU_Cache() { super(3, 0.75f, true); }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) { return size() > capacity; }
}
