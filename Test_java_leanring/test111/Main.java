package Test_java_leanring.test111;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/** test111 - ConcurrentHashMap */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test111: ConcurrentHashMap ===");
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 1);
        System.out.println(map.get("a"));
    }
}
