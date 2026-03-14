/**
 * INTERVIEWER: Single Responsibility Principle?
 * CANDIDATE: A class should have one, and only one, reason to change.
 */
class Invoice { void calculateTotal() {} }
class InvoicePrinter { void print(Invoice i) {} }
public class Q1_SRP {
    public static void main(String[] args) {
        System.out.println("Invoice and Printer are separate responsibilities.");
    }
}
