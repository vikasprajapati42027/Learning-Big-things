public class NullObjectDemo {
    public static void main(String[] args) {
        AbstractCustomer c1 = CustomerFactory.getCustomer("Vikas");
        AbstractCustomer c2 = CustomerFactory.getCustomer("Julie"); // Doesn't exist

        System.out.println("Customer 1: " + c1.getName());
        System.out.println("Customer 2: " + c2.getName());
        
        // No NullPointerException!
    }
}
