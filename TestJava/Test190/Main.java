package TestJava.Test190;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Putting it all together: A Mini-ORM Session!

@Retention(RetentionPolicy.RUNTIME) @interface Table { String name(); }
@Retention(RetentionPolicy.RUNTIME) @interface Id {}

@Table(name = "vehicles")
class Car {
    @Id public int carId;
    public String model;
    
    public Car() {} // For reflective instantiation
    public Car(int id, String m) { this.carId = id; this.model = m; }
    public String toString() { return "Car{" + carId + ", '" + model + "'}"; }
}

class MiniSession {
    private Map<String, Object> cache = new HashMap<>();

    public void save(Object entity) throws Exception {
        Class<?> clazz = entity.getClass();
        String table = clazz.getAnnotation(Table.class).name();
        
        Field idField = null;
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Id.class)) idField = f;
        }
        
        if (idField == null) throw new RuntimeException("No @Id field found!");
        
        // Construct cache key and INSERT query
        String cacheKey = clazz.getSimpleName() + "-" + idField.get(entity);
        System.out.println("[MiniSession] INSERT INTO " + table + " VALUES (...)");
        
        // Cache it!
        cache.put(cacheKey, entity);
    }

    public <T> T get(Class<T> clazz, int id) throws Exception {
        String cacheKey = clazz.getSimpleName() + "-" + id;
        
        if (cache.containsKey(cacheKey)) {
            System.out.println("[MiniSession] Fast L1 Cache Hit for " + cacheKey);
            return (T) cache.get(cacheKey);
        }
        
        System.out.println("[MiniSession] Cache Miss! SELECT * FROM " + clazz.getAnnotation(Table.class).name() + " WHERE id = " + id);
        // Simulate DB return
        T newObj = clazz.getDeclaredConstructor().newInstance();
        
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Id.class)) f.set(newObj, id);
            else if (f.getType() == String.class) f.set(newObj, "Loaded_From_DB_" + id);
        }
        
        cache.put(cacheKey, newObj); // Cache for later!
        return newObj;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 190: Mini ORM Integration Session ===\n");

        MiniSession session = new MiniSession();

        System.out.println("1. Saving a new Car...");
        Car newCar = new Car(90, "Tesla Model S");
        session.save(newCar);

        System.out.println("\n2. Fetching Car #90 (Should hit cache!)");
        Car loadedCar = session.get(Car.class, 90);
        System.out.println("Returned: " + loadedCar);
        
        System.out.println("\n3. Fetching Car #25 (Should hit database!)");
        Car dbCar = session.get(Car.class, 25);
        System.out.println("Returned: " + dbCar);
    }
}
