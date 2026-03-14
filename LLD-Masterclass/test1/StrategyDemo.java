public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentMethod(new CreditCardPayment());
        cart.checkout(1000);

        // Change mind! Pay using UPI
        cart.setPaymentMethod(new UpiPayment());
        cart.checkout(1000);
    }
}
