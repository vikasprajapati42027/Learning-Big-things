package Test_java_leanring.test60;

import java.util.TreeMap;
import java.util.Map;

/** test60 - TreeMap (sorted keys) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test60: TreeMap ===");
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3); map.put("a", 1);
        System.out.println(map);
    }
}
