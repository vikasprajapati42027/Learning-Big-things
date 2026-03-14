package TestJava.Test11;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Enums & Optionals Tutorial ===");

        // 1. ENUMS
        System.out.println("\n--- 1. Enums ---");
        Day today = Day.FRIDAY;
        System.out.println("Today is " + today + " which is a " + today.getType());

        // 2. MODERN SWITCH EXPRESSIONS (Java 14+)
        // They look cleaner, don't require 'break', and can return a value!
        System.out.println("\n--- 2. Modern Switch Expression ---");
        String activity = switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> "Writing code...";
            case FRIDAY -> "Deploying code and hoping it doesn't break!";
            case SATURDAY, SUNDAY -> "Relaxing!";
        };
        System.out.println("Activity for today: " + activity);

        // 3. OPTIONALS (Java 8+)
        // A container object which may or may not contain a non-null value.
        // It's the modern way to avoid NullPointerExceptions.
        System.out.println("\n--- 3. Optionals (Null Safety) ---");
        
        Optional<String> optionalEmail = fetchEmailFromServer(true); // Pretend this succeeds
        Optional<String> missingEmail = fetchEmailFromServer(false); // Pretend this fails (returns null)

        // Old way (Risky):
        // String email = fetchEmail();
        // if(email != null) { System.out.println(email.toUpperCase()); }

        // Modern Optional way (Safe and Declarative):
        // ifPresent executes the lambda ONLY if the value is not null!
        optionalEmail.ifPresent(email -> System.out.println("Fetched Email: " + email.toUpperCase()));
        
        // providing a default value if missing
        String finalEmail = missingEmail.orElse("no-reply@domain.com");
        System.out.println("Missing email resolved to: " + finalEmail);
    }

    // A method that might find something, or might find nothing (null)
    private static Optional<String> fetchEmailFromServer(boolean success) {
        if (success) {
            return Optional.of("user123@example.com");
        } else {
            return Optional.empty(); // Safely wrapping a "null" state
        }
    }
}
