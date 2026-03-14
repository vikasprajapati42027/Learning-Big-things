package TestJava.Test189;

import java.util.HashMap;
import java.util.Map;

class HibernateSessionMock {
    // Level 1 Cache (Session-scoped)
    // Key: Class name + ID -> Value: Entity Object
    private Map<String, Object> firstLevelCache = new HashMap<>();

    public Object get(Class<?> clazz, int id) {
        String cacheKey = clazz.getSimpleName() + "-" + id;
        
        if (firstLevelCache.containsKey(cacheKey)) {
            System.out.println("[Cache HIT] Returning " + cacheKey + " from Memory immediately!");
            return firstLevelCache.get(cacheKey);
        } else {
            System.out.println("[Cache MISS] Sending SQL Query to Database for " + cacheKey + "...");
            System.out.println("SELECT * FROM " + clazz.getSimpleName().toLowerCase() + " WHERE id = " + id);
            
            // Constructing a new object
            Object dbResult = buildMockObject(clazz, id);
            
            // Save it in the cache!
            firstLevelCache.put(cacheKey, dbResult);
            return dbResult;
        }
    }
    
    private Object buildMockObject(Class<?> clazz, int id) {
        return "InstanceOf" + clazz.getSimpleName() + "#" + id;
    }
}

class Customer {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 189: Caching Layer (L1 Cache Concept) ===\n");

        System.out.println("Hibernate's Level-1 Cache is completely tied to a single Session.");
        System.out.println("If you query the same object twice inside one transaction, it only hits the DB once!\n");

        HibernateSessionMock session = new HibernateSessionMock();
        
        System.out.println("--- First Query for Customer #5 ---");
        Object result1 = session.get(Customer.class, 5);
        
        System.out.println("\n--- Second Query for Customer #5 ---");
        Object result2 = session.get(Customer.class, 5);
        
        System.out.println("\nAre the two objects exactly the same reference? " + (result1 == result2));
        
        System.out.println("\n--- Query for Customer #9 ---");
        session.get(Customer.class, 9);
    }
}
