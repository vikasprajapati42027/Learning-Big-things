/**
 * INTERVIEWER: Single Responsibility Principle?
 * CANDIDATE: A class should have one, and only one, reason to change.
 */
import java.util.*;

final class LineItem {
    private final String product;
    private final int quantity;
    private final double pricePerUnit;

    LineItem(String product, int quantity, double pricePerUnit) {
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    double total() {
        return quantity * pricePerUnit;
    }

    @Override
    public String toString() {
        return quantity + "x " + product + " @ " + pricePerUnit;
    }
}

class Invoice {
    private final int number;
    private final List<LineItem> items;

    Invoice(int number, List<LineItem> items) {
        this.number = number;
        this.items = new ArrayList<>(items);
    }

    double calculateTotal() {
        return items.stream().mapToDouble(LineItem::total).sum();
    }

    int getNumber() {
        return number;
    }

    List<LineItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}

class InvoicePrinter {
    void print(Invoice invoice) {
        System.out.println("Invoice #" + invoice.getNumber());
        invoice.getItems().forEach(item -> System.out.println("  " + item));
        System.out.println("Total: " + invoice.calculateTotal());
    }
}

public class Q1_SRP {
    public static void main(String[] args) {
        List<LineItem> items = Arrays.asList(
            new LineItem("Laptop", 1, 1200.0),
            new LineItem("Monitor", 2, 240.0)
        );
        Invoice invoice = new Invoice(1001, items);
        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);
    }
}
