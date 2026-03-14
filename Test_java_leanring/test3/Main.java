package Test_java_leanring.test3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test3: Interface ===");

        Enrollable e = new EnrolledStudent("Alice", 1, "Java");
        e.enroll("Advanced Java");
    }
}
