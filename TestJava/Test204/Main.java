package TestJava.Test204;

import java.util.HashMap;
import java.util.Map;

class UserData {
    public int id = 99;
    public String name = "GraphQL Guru";
    public String email = "guru@graphql.org";
    public int age = 30;
    public String hobby = "Coding";
    
    // Convert object to Map for easier dynamic property access
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("email", email);
        map.put("age", age);
        map.put("hobby", hobby);
        return map;
    }
}

// A highly simplified Mock GraphQL Engine
class MockGraphQLEngine {
    private final UserData dbRow = new UserData(); 

    // Takes a GraphQL Query String and returns JSON
    public String executeQuery(String query) {
        System.out.println("\n[GraphQL Engine] Received Query:\n" + query);
        
        // 1. Basic parsing (Extracting requested fields between { })
        String inner = query.substring(query.indexOf("{") + 1, query.lastIndexOf("}")).trim();
        inner = inner.replace("\n", "").replace(" ", ""); // remove whitespace
        String[] requestedFields = inner.split(","); // Assuming comma separated

        // 2. Data Fetching and JSON building
        Map<String, Object> dataMap = dbRow.toMap();
        StringBuilder jsonResponse = new StringBuilder("{\n  \"data\": {\n");
        
        for (int i = 0; i < requestedFields.length; i++) {
            String field = requestedFields[i].trim();
            if (dataMap.containsKey(field)) {
                Object val = dataMap.get(field);
                String valStr = (val instanceof String) ? "\"" + val + "\"" : val.toString();
                
                jsonResponse.append("    \"").append(field).append("\": ").append(valStr);
                if (i < requestedFields.length - 1) jsonResponse.append(",");
                jsonResponse.append("\n");
            }
        }
        
        jsonResponse.append("  }\n}");
        return jsonResponse.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 204: GraphQL Query Parser Concept ===\n");

        System.out.println("REST API 'Over-fetching': /api/users/99 returns ID, Name, Email, Age, Hobby etc.");
        System.out.println("What if the Mobile app ONLY needs the name? Enter GraphQL: Ask for exactly what you want!\n");

        MockGraphQLEngine engine = new MockGraphQLEngine();

        // Mobile App Query (Needs less data)
        String mobileQuery = "{\n  name,\n  age\n}";
        System.out.println("Response to Mobile App:");
        System.out.println(engine.executeQuery(mobileQuery));

        // Desktop Web App Query (Needs more data)
        String webQuery = "{\n  id,\n  name,\n  email,\n  hobby\n}";
        System.out.println("\nResponse to Web App:");
        System.out.println(engine.executeQuery(webQuery));
    }
}
