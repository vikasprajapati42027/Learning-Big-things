package TestJava.Test8;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Thread Synchronization Tutorial ===");
        
        // 1. Create a SINGLE shared BankAccount exactly ONE object.
        BankAccount sharedAccount = new BankAccount();

        // 2. Create multiple tasks (Runnables) that use the SAME BankAccount.
        Runnable husbandTask = () -> {
            System.out.println("Husband thread starting...");
            // He tries to withdraw 800
            for(int i=0; i<2; i++) {
                sharedAccount.withdraw(600, "Husband");
            }
        };

        Runnable wifeTask = () -> {
            System.out.println("Wife thread starting...");
            // She tries to withdraw 800
            for(int i=0; i<2; i++) {
                sharedAccount.withdraw(600, "Wife");
            }
        };

        // 3. Create real threads out of these Runnables
        Thread t1 = new Thread(husbandTask);
        Thread t2 = new Thread(wifeTask);

        System.out.println("Initial Balance: $" + sharedAccount.getBalance());

        // 4. Start the threads! They will race to try and withdraw.
        t1.start();
        t2.start();
        
        // Wait for both to finish before printing final state
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}

        System.out.println("\nFinal Final Balance is: $" + sharedAccount.getBalance());
        
        /* 
         * Important Lesson:
         * If `BankAccount.withdraw()` was NOT synchronized, both threads could check
         * `balance >= amount` at the exact same time when balance=1000. 
         * Both would pass the 'if', sleep, and then both subtract 600, 
         * leading to a final balance of -200! 
         * The `synchronized` keyword prevents this race condition.
         */
    }
}
