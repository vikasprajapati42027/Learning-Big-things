package Test_java_leanring.test92;

/** test92 - Factory method */
class Product {
    static Product create() { return new Product(); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test92: Factory method ===");
        System.out.println(Product.create());
    }
}
