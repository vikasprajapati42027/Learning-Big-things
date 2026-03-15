/**
 * INTERVIEWER: SOLID Principle Scenario 9.
 * CANDIDATE: Professional implementation of SOLID principle 9.
 */
import java.util.HashMap;
import java.util.Map;
class Cache {
    private final Map<String, String> store = new HashMap<>();

    void put(String key, String value) {
        store.put(key, value);
    }

    String get(String key) {
        return store.get(key);
    }
}

class DataFetcher {
    private final Cache cache;

    DataFetcher(Cache cache) {
        this.cache = cache;
    }

    String fetch(String key) {
        String cached = cache.get(key);
        if (cached != null) {
            return "Cache hit: " + cached;
        }
        String fresh = "Value-for-" + key;
        cache.put(key, fresh);
        return "Fetched: " + fresh;
    }
}

public class Q9_SOLID {
    public static void main(String[] args) {
        Cache cache = new Cache();
        DataFetcher fetcher = new DataFetcher(cache);
        System.out.println(fetcher.fetch("user123"));
        System.out.println(fetcher.fetch("user123"));
    }
}
