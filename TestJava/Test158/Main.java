package TestJava.Test158;

import java.lang.reflect.Field;

class UserData {
    public String username; // Note: Public for simple reflection demo
    public int age;
    
    @Override
    public String toString() { return "UserData{username='" + username + "', age=" + age + "}"; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 158: JSON Deserialization (Reflection Concept) ===\n");

        System.out.println("How does Jackson turn a JSON string back into a Java Object?");
        System.out.println("It parses the text, then uses standard Reflection API to inject values!\n");

        String rawJson = "{\n  \"username\": \"vikas_admin\",\n  \"age\": 30\n}";
        System.out.println("Raw JSON Input:\n" + rawJson + "\n");

        // 1. Simulating the JSON Parser (Extracting flat key-value strings)
        String cleanedStr = rawJson.replace("{", "").replace("}", "").replace("\"", "").replace(" ", "").replace("\n", "");
        String[] pairs = cleanedStr.split(","); // e.g., ["username:vikas_admin", "age:30"]

        // 2. Reflection mapping to the Class
        UserData user = new UserData();
        Class<?> clazz = user.getClass();

        for (String pair : pairs) {
            String[] split = pair.split(":");
            String key = split[0];
            String value = split[1];

            try {
                // Find the field dynamically by its name ("username" or "age")
                Field field = clazz.getDeclaredField(key);
                
                // Set accessible in case it was private
                field.setAccessible(true);
                
                // Convert type intelligently and INJECT into the object!
                if (field.getType() == int.class) {
                    field.setInt(user, Integer.parseInt(value));
                } else if (field.getType() == String.class) {
                    field.set(user, value);
                }
                
            } catch (NoSuchFieldException e) {
                System.out.println("[Warning] Unknown attribute in JSON: " + key);
            }
        }

        System.out.println("Successfully deserialized into Java Object!");
        System.out.println("Output: " + user.toString());
    }
}
