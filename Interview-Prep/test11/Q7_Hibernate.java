/**
 * INTERVIEWER: Hibernate Topic 7.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
import java.util.*;

public class Q7_Hibernate {
    static class CacheRegion {
        private final Map<Long, String> store = new HashMap<>();

        void put(Long key, String value) {
            store.put(key, value);
            System.out.println("Caching: " + key);
        }

        String get(Long key) {
            System.out.println("Cache lookup: " + key);
            return store.get(key);
        }
    }

    public static void main(String[] args) {
        CacheRegion region = new CacheRegion();
        region.put(1L, "EntityOne");
        System.out.println("Fetched: " + region.get(1L));
    }
}
