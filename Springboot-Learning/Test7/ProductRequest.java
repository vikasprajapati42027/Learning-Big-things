package Test7;

/**
 * DTO for the @RequestBody example.
 * Represents a product being sent to the server.
 */
public class ProductRequest {

    private String name;
    private double price;

    // Default constructor is required for Jackson to deserialize JSON
    public ProductRequest() {}

    public ProductRequest(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
