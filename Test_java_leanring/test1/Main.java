package Test_java_leanring.test1;

/**
 * test1 - Class and Object basics.
 * Next (test2) we build on this with a related class (e.g. inheritance).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test1: Class and Object ===");

        Student s1 = new Student("Alice", 1);
        Student s2 = new Student("Bob", 2);

        s1.introduce();
        s2.introduce();

        System.out.println("\nNext: test2 will add a related class building on Student.");
    }
}
