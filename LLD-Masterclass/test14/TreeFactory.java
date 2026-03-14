import java.util.HashMap;
import java.util.Map;

// The Factory ensures we don't create duplicate TreeTypes!
public class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color) {
        String key = name + "_" + color;
        if (!treeTypes.containsKey(key)) {
            System.out.println("Creating NEW TreeType for: " + key);
            treeTypes.put(key, new TreeType(name, color));
        }
        return treeTypes.get(key);
    }
}
