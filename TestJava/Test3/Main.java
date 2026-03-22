package TestJava.Test3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Multiple Interface Tutorial ===");

        Duck donald = new Duck();

        // One object can perform actions from multiple interfaces!
        donald.fly();
        donald.swim();

        System.out.println("\nOne class, multiple behaviors: SUCCESS!");


        Swimmable  res = () -> System.out.println("Duck are smart now");
        res.swim();
        Swimmable res1= new Duck();
        res1.swim();
    }
}
