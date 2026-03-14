package TestJava.Test157;

import java.util.List;

record Product(int id, String name, double price, boolean inStock) {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 157: JSON Serialization Concept ===\n");

        System.out.println("Libraries like Jackson or Gson do this automatically using Reflection.");
        System.out.println("But manually building JSON strings teaches us what they do under the hood!\n");

        Product p1 = new Product(101, "Ultra Monitor", 299.99, true);
        Product p2 = new Product(102, "Mechanical Keyboard", 120.50, false);
        
        List<Product> catalog = List.of(p1, p2);

        // serialize single object
        String json1 = serializeToJson(p1);
        System.out.println("Single Object JSON:");
        System.out.println(json1);
        
        // serialize array
        System.out.println("\nArray JSON:");
        System.out.println(serializeListToJson(catalog));
    }

    // A manual approach (without external libraries)
    private static String serializeToJson(Product p) {
        // Let's use string concatenation carefully to format JSON
        // Notice the escaped quotes `\"` for string values and keys!
        return String.format(
            "{\n  \"id\": %d,\n  \"name\": \"%s\",\n  \"price\": %.2f,\n  \"inStock\": %b\n}",
            p.id(), p.name(), p.price(), p.inStock()
        );
    }

    private static String serializeListToJson(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < products.size(); i++) {
            // Indent the single object JSON by replacing newlines
            String indentedObj = serializeToJson(products.get(i)).replace("\n", "\n  ");
            sb.append("  ").append(indentedObj);
            
            if (i < products.size() - 1) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
