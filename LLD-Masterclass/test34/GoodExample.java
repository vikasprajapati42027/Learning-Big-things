public class OrderApp {
    private void validateUser() {
        if (user == null) throw new Error();
    }
    public void createOrder() {
        validateUser();
        // Save
    }
    public void updateOrder() {
        validateUser();
        // Update
    }
}
