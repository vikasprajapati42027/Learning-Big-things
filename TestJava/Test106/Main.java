package TestJava.Test106;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Switch Expressions (Java 14+) ===\n");

        String day = "SATURDAY";

        // Old Way (Statements)
        System.out.println("--- 1. Old Switch Statement ---");
        String type1;
        switch (day) {
            case "MONDAY":
            case "TUESDAY":
            case "WEDNESDAY":
            case "THURSDAY":
            case "FRIDAY":
                type1 = "Weekday";
                break;
            case "SATURDAY":
            case "SUNDAY":
                type1 = "Weekend";
                break;
            default:
                type1 = "Unknown";
        }
        System.out.println("Old Way: " + type1);

        // New Way (Expressions returning a value)
        System.out.println("\n--- 2. Modern Switch Expression ---");
        // No 'break' needed! Fallthrough is disabled by default with '->'
        String type2 = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> "Unknown";
        };
        System.out.println("New Way: " + type2);

        // Using Yield (when you need logic inside a case)
        System.out.println("\n--- 3. Switch Expression with 'yield' ---");
        String dayStatus = switch (day) {
            case "MONDAY", "FRIDAY" -> {
                System.out.println("Computing busy day logic...");
                // 'yield' is the new 'return' for switch blocks!
                yield "Busy Day"; 
            }
            case "SATURDAY", "SUNDAY" -> "Relax Day";
            default -> "Normal Day";
        };
        System.out.println("Status: " + dayStatus);
    }
}
