package Test_java_leanring.test97;

import java.util.EnumMap;
import java.util.Map;

enum Key { X, Y }

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test97: EnumMap ===");
        Map<Key, String> map = new EnumMap<>(Key.class);
        map.put(Key.X, "one");
        System.out.println(map.get(Key.X));
    }
}
