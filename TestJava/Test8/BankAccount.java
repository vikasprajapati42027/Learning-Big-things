package TestJava.Test8;

/**
 * A shared resource (like a bank account) where multiple threads will try to
 * perform operations at the same time, leading to a Race Condition if not handled.
 */
public class BankAccount {
    private int balance = 1000;

    /**
     * Using the 'synchronized' keyword on the method ensures that 
     * only ONE thread can execute this method on this object at a time.
     * It locks the object.
     */
    public synchronized void withdraw(int amount, String threadName) {
        if (balance >= amount) {
            System.out.println(threadName + " is about to withdraw $" + amount + "...");
            
            // Simulating processing time which makes Race Conditions more likely to occur
            try { Thread.sleep(100); } catch (Exception e) {}
            
            balance -= amount;
            System.out.println(threadName + " successfully withdrew $" + amount + ". Remaining Balance: $" + balance);
        } else {
            System.out.println(threadName + " attempted to withdraw $" + amount + ", but insufficient funds! Balance: $" + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}
