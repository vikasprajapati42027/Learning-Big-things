package TestJava.Test234;

import java.security.MessageDigest;
import java.util.SortedMap;
import java.util.TreeMap;

class ConsistentHashPool {
    // We use a TreeMap (which implies a circle) to hold servers on the ring.
    private final SortedMap<Integer, String> ring = new TreeMap<>();
    private final int virtualNodes; // Replicas for better distribution

    public ConsistentHashPool(int virtualNodes) {
        this.virtualNodes = virtualNodes;
    }

    // Add a server to the ring
    public void addServer(String server) {
        for (int i = 0; i < virtualNodes; i++) {
            // We hash "server-0", "server-1" to spread them around the ring
            int hash = getHash(server + "-VNode" + i);
            ring.put(hash, server);
        }
        System.out.println("- Server " + server + " added (with " + virtualNodes + " virtual nodes).");
    }

    public void removeServer(String server) {
        for (int i = 0; i < virtualNodes; i++) {
            int hash = getHash(server + "-VNode" + i);
            ring.remove(hash);
        }
        System.out.println("- Server " + server + " CRASHED and was removed.");
    }

    // Find which server should hold the data!
    public String getServerForData(String dataKey) {
        if (ring.isEmpty()) return null;
        
        int hash = getHash(dataKey);
        
        // Find the next server on the circle (clockwise)
        SortedMap<Integer, String> tailMap = ring.tailMap(hash);
        
        if (tailMap.isEmpty()) {
            // We reached the end of the circle! Loop back to the first server.
            return ring.get(ring.firstKey());
        }
        
        return tailMap.get(tailMap.firstKey());
    }

    // A simple hash function returning an Integer (representing a point on the circle)
    private int getHash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes());
            // Take the first 4 bytes to make an int
            return ((digest[3] & 0xFF) << 24) | ((digest[2] & 0xFF) << 16) |
                   ((digest[1] & 0xFF) << 8) | (digest[0] & 0xFF);
        } catch (Exception e) { return key.hashCode(); }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 234: Consistent Hashing Concept ===\n");

        System.out.println("Problem: You have 3 Redis servers. If you hash keys via 'hash(key) % 3',");
        System.out.println("         and one server crashes, 'hash(key) % 2' changes the location of ALL keys!");
        System.out.println("         Every cache miss hits the database at once, causing a catastrophe.\n");

        System.out.println("Solution: Consistent Hashing! Map servers and keys to a Ring. ONLY the keys");
        System.out.println("          from the crashed server are remapped to the next server clockwise.\n");

        ConsistentHashPool cacheCluster = new ConsistentHashPool(5); // 5 virtual nodes per server for balance

        cacheCluster.addServer("Redis-Node-A");
        cacheCluster.addServer("Redis-Node-B");
        cacheCluster.addServer("Redis-Node-C");

        System.out.println("\n--- Mapping Data to Servers ---");
        String[] dataKeys = {"user:101", "user:502", "product:99", "cart:xyz", "session:abc"};
        
        for (String key : dataKeys) {
            String targetServer = cacheCluster.getServerForData(key);
            System.out.println("Data '" + key + "' -> Routed to " + targetServer);
        }

        System.out.println("\n--- Disaster Strikes ---");
        cacheCluster.removeServer("Redis-Node-B");

        System.out.println("\n--- Remapping Data (Notice how few keys moved!) ---");
        for (String key : dataKeys) {
            String targetServer = cacheCluster.getServerForData(key);
            System.out.println("Data '" + key + "' -> Now on " + targetServer);
        }
    }
}
