package Test_java_leanring.test42;

public class Main {
    static void check(int id) throws InvalidIdException {
        if (id < 0) throw new InvalidIdException("id < 0");
    }
    public static void main(String[] args) {
        System.out.println("=== test42: Custom exception ===");
        try {
            check(1);
            check(-1);
        } catch (InvalidIdException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
