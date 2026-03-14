package TestJava.Test38;

class OuterClass {
    private String outerData = "Top Secret Info";

    // 1. Static Nested Class
    // Can be instantiated without an instance of the outer class.
    // CANNOT access non-static members of OuterClass.
    static class StaticNested {
        void printStatus() {
            System.out.println("Inside Static Nested Class (No access to outerData)");
        }
    }

    // 2. Non-Static Inner Class
    // REQUIRES an instance of the OuterClass to exist.
    // CAN access all members of the OuterClass, even private ones!
    class InnerClass {
        void printData() {
            System.out.println("Inside Inner Class (Accessing outerData): " + outerData);
        }
    }

    public void demonstrateLocalAndAnonymous() {
        // 3. Local Inner Class (Defined inside a method!)
        class LocalInner {
            void run() { System.out.println("Inside Local Inner Class!"); }
        }
        new LocalInner().run();

        // 4. Anonymous Inner Class
        // Creating a one-time use subclass of Runnable on the fly without giving it a name.
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Anonymous Inner Class!");
            }
        };
        myRunnable.run();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Nested & Inner Classes ===");

        // --- 1. Static Nested ---
        OuterClass.StaticNested staticNested = new OuterClass.StaticNested();
        staticNested.printStatus();

        // --- 2. Non-Static Inner ---
        // We MUST create an Outer object first!
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.printData();

        // --- 3 & 4. Local and Anonymous ---
        outer.demonstrateLocalAndAnonymous();
    }
}
