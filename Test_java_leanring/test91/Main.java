package Test_java_leanring.test91;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test91: Copy constructor ===");
        Person p1 = new Person("Alice");
        Person p2 = new Person(p1);
        System.out.println(p2.name);
    }
}
