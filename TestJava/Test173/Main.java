package TestJava.Test173;

// 1. The Handler Interface/Abstract Class
abstract class Approver {
    protected Approver nextApprover;

    public void setNext(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approveExpense(int amount);
}

// 2. Concrete Handlers!
class Manager extends Approver {
    public void approveExpense(int amount) {
        if (amount <= 1000) {
            System.out.println("Manager approved the expense of $" + amount);
        } else if (nextApprover != null) {
            System.out.println("Manager cannot approve $" + amount + ". Escalating to Director...");
            nextApprover.approveExpense(amount);
        }
    }
}

class Director extends Approver {
    public void approveExpense(int amount) {
        if (amount <= 10000) {
            System.out.println("Director approved the expense of $" + amount);
        } else if (nextApprover != null) {
            System.out.println("Director cannot approve $" + amount + ". Escalating to CEO...");
            nextApprover.approveExpense(amount);
        }
    }
}

class CEO extends Approver {
    public void approveExpense(int amount) {
        if (amount <= 100000) {
            System.out.println("CEO approved the expense of $" + amount);
        } else {
            System.out.println("Expense of $" + amount + " REJECTED! We don't have that much money.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 173: Chain of Responsibility ===\n");

        System.out.println("Passes a request along a chain of handlers until one of them handles it.");
        System.out.println("Example: Servlet Filters or Logger Level processing!\n");

        // 1. Create the chain
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        manager.setNext(director);
        director.setNext(ceo);

        // 2. Test scenarios
        System.out.println("Employee Request 1: $500 (Office Supplies)");
        manager.approveExpense(500);
        
        System.out.println("\nEmployee Request 2: $5000 (New Laptops)");
        manager.approveExpense(5000);
        
        System.out.println("\nEmployee Request 3: $50000 (New Office Rent)");
        manager.approveExpense(50000);
        
        System.out.println("\nEmployee Request 4: $1000000 (Superbowl Ad)");
        manager.approveExpense(1000000);
    }
}
