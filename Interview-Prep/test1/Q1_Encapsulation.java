/**
 * INTERVIEWER: Explain Encapsulation with a real-world edge case.
 * 
 * CANDIDATE: Encapsulation is the mechanism of wrapping data (fields) and code (methods) 
 * into a single unit. It provides data hiding and control over how data is accessed.
 *
 * PROPER EXPLANATION:
 * 1. Data Hiding: Keep fields private.
 * 2. Control: Use setters to validate data (e.g., negative salary check).
 * 3. Flexibility: You can change the internal implementation without affecting the caller.
 * 4. Read-Only/Write-Only: By providing only getters or only setters.
 */

class Account {
    private double balance; // Data hiding
    private String accountNumber;

    public Account(String accNo, double initialBalance) {
        this.accountNumber = accNo;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    // High-level Logic: Securely update balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful. New Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class Q1_Encapsulation {
    public static void main(String[] args) {
        Account myAcc = new Account("SA-123", 1000.0);
        myAcc.deposit(500.0);
        System.out.println("Account: " + myAcc.getAccountNumber() + " has " + myAcc.getBalance());
        
        // myAcc.balance = -500; // COMPILATION ERROR: balance is private
    }
}
