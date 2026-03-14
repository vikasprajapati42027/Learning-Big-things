package Test_java_leanring.test28;

import java.util.HashMap;
import java.util.Map;

/** test28 - HashMap */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test28: HashMap ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1); map.put("b", 2);
        System.out.println(map.get("a") + " " + map);
    }
}
