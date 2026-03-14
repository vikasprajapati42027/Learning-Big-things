package Test_java_leanring.test128;

import java.util.LinkedHashMap;
import java.util.Map;

/** test128 - LinkedHashMap (insertion order) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test128: LinkedHashMap ===");
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("c", 3); map.put("a", 1);
        System.out.println(map.keySet());
    }
}
