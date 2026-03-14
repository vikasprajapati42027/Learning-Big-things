abstract class Account { double bal; }
class SavingsAccount extends Account { }
public class SingleTableDemo {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount();
        System.out.println("Single Table: SavingsAccount inherits from Account");
    }
}
