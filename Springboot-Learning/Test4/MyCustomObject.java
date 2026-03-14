package Test4;

/**
 * This is a simple POJO (Plain Old Java Object).
 * Notice it has NO Spring annotations like @Component.
 * Normally, Spring wouldn't know about this class.
 */
public class MyCustomObject {

    private String message;

    public MyCustomObject(String message) {
        this.message = message;
    }

    public void displayMessage() {
        System.out.println("Custom Object says: " + message);
    }
}
