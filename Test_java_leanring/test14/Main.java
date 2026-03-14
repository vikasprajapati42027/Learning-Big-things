package Test_java_leanring.test14;

/** test14 - super() and constructor chaining */
class Parent { Parent() { System.out.println("Parent"); } }
class Child extends Parent { Child() { super(); System.out.println("Child"); } }

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test14: super() ===");
        new Child();
    }
}
