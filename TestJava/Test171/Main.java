package TestJava.Test171;

import java.util.HashMap;
import java.util.Map;

// 1. the Target interface
interface Shape {
    void draw(int x, int y, String color);
}

// 2. The Concrete Flyweight Object
// We ONLY store intrinsic (shared) state here. Not X, Y or Color!
class CircleType implements Shape {
    private final String name;
    private final byte[] heavyImageTexture; // Represents MBs of memory

    public CircleType(String name) {
        this.name = name;
        this.heavyImageTexture = new byte[1024 * 1024]; // Simulate 1MB heavy object
        System.out.println("--- Heavy '" + name + "' texture loaded into memory! ---");
    }

    @Override
    public void draw(int x, int y, String color) {
        System.out.println("Drawing " + name + " [Color: " + color + ", x=" + x + ", y=" + y + "]");
    }
}

// 3. The Flyweight Factory
// This ensures that we only instantiate ONE heavy texture per Type!
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String type) {
        circleMap.putIfAbsent(type, new CircleType(type));
        return circleMap.get(type);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 171: Flyweight Pattern (Memory Optimization) ===\n");

        System.out.println("If you are drawing a forest with 10,000 trees, don't create 10,000 Tree objects!");
        System.out.println("Create ONE 'TreeType' object and just pass the X,Y coordinates when drawing.\n");

        // We want to draw 5 green circles and 5 red circles
        for (int i = 0; i < 5; i++) {
            Shape circle = ShapeFactory.getCircle("Basic Circle");
            circle.draw(i * 10, i * 20, "Green");
        }

        System.out.println("\nNotice how the 'heavy texture' was only loaded ONCE!");
        
        for (int i = 0; i < 5; i++) {
            Shape circle = ShapeFactory.getCircle("Basic Circle");
            circle.draw(i * 15, i * 25, "Red");
        }
        
        System.out.println("\nReal World Example: java.lang.String pool uses the Flyweight pattern!");
        System.out.println("Integer.valueOf(5) uses Flyweight to reuse small Integer objects!");
    }
}
