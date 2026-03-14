package TestJava.Test114;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== String Templates (Java 21 Preview) ===\n");

        String name = "Vikas";
        String language = "Java";
        int testsCompleted = 114;

        System.out.println("--- Java 17 Approaches ---");
        
        // 1. Concatenation (Ugly, error-prone)
        String s1 = name + " is learning " + language + " and has completed " + testsCompleted + " tests.";
        System.out.println("Concatenation: " + s1);
        
        // 2. String.format (Cleaner, but disconnects variables from the string)
        String s2 = String.format("%s is learning %s and has completed %d tests.", name, language, testsCompleted);
        System.out.println("String.format: " + s2);

        System.out.println("\n--- Java 21+ Approach (String Templates) ---");
        System.out.println("In Java 21, you can embed variables DIRECTLY inside the string using the STR processor:");
        System.out.println("String result = STR.\"\\{name} is learning \\{language} and has completed \\{testsCompleted} tests.\";");
        
        System.out.println("\nBonus: You can even include execution logic inside the template blocks!");
        System.out.println("String math = STR.\"The answer is \\{5 * 5} \";");
    }
}
