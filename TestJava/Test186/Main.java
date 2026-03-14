package TestJava.Test186;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
    public int id;
    public String username;
    public String role;
    
    @Override
    public String toString() { return "User{" + "id=" + id + ", username='" + username + "', role='" + role + "'}"; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 186: ResultSet to Object Mapper ===\n");

        System.out.println("When you call session.get(User.class, 1), Hibernate gets the ResultSet");
        System.out.println("from the DB and dynamically builds your Java object using Reflection!\n");

        // 1. Simulating a java.sql.ResultSet returned from the database
        Map<String, Object> mockResultSetRow = new HashMap<>();
        mockResultSetRow.put("id", 42);
        mockResultSetRow.put("username", "neo");
        mockResultSetRow.put("role", "admin");

        System.out.println("Raw Row Data from DB: " + mockResultSetRow);

        // 2. The ORM Mapping Logic
        Class<User> clazz = User.class;
        
        // Ensure it has a no-arg constructor!
        User entityInstance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            // Find the corresponding column in the ResultSet by field name
            Object dbValue = mockResultSetRow.get(field.getName());
            
            if (dbValue != null) {
                // Warning: In a real ORM we must handle type casting (e.g. Number -> Int)
                field.setAccessible(true);
                field.set(entityInstance, dbValue);
            }
        }

        System.out.println("Generated Java Object: " + entityInstance.toString());
    }
}
