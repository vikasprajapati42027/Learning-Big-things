package TestJava.Test4;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Interface Inheritance Tutorial ===");

        // We use the AdvancedControl type but create a SmartDevice
        AdvancedControl mySpeaker = new SmartDevice();

        // 1. Methods from the Parent Interface (BasicControl)
        mySpeaker.on();

        // 2. Methods from the Child Interface (AdvancedControl)
        mySpeaker.setting("Bass Boost On");

        // 3. Methods from Parent again
        mySpeaker.off();

        System.out.println("\nInterface hierarchy works exactly like class hierarchy!");
    }
}
