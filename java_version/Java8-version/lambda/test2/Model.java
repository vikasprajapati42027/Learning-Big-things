package java_version.Java8_version.lambda.test2;

/**
 * Model - holds data (MVC).
 * No UI logic, only state.
 */
public class Model {
    private String message = "";
    private int count = 0;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }
}
