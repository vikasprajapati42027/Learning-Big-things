package Test_java_leanring.test4;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test4: Abstract class ===");

        Person p = new Teacher("Mr. Smith", "Math");
        System.out.println(p.getName() + " - " + p.getRole());
    }
}
