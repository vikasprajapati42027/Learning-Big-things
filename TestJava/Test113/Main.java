package TestJava.Test113;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Unnamed Patterns & Variables (Java 22) ===\n");

        System.out.println("In modern Java (22+), the underscore '_' is a reserved keyword");
        System.out.println("used to denote variables that you MUST declare, but DO NOT intend to use!\n");

        String numberString = "Not_A_Number";

        System.out.println("--- Java 17 Approach ---");
        try {
            int val = Integer.parseInt(numberString);
            System.out.println("Value: " + val);
        } catch (NumberFormatException ignoredException) {
            // We have to declare 'ignoredException', even if we never use it.
            // Tools like SonarQube often complain about unused variables here.
            System.out.println("Validation Failed. Not a valid number!");
        }

        System.out.println("\n--- Java 22+ Approach ---");
        System.out.println("catch (NumberFormatException _) {");
        System.out.println("    System.out.println(\"Validation Failed.\");");
        System.out.println("}");
        
        System.out.println("\nThis also works for unused lambda parameters:");
        System.out.println("map.forEach((key, _) -> System.out.println(key));");
        System.out.println("It tells the compiler and other devs: 'I intentionally don't care about this variable.'");
    }
}
