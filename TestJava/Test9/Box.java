package TestJava.Test9;

/**
 * A Generic Class!
 * The <T> stands for "Type". We can replace T with ANY object type
 * when we instantiate this class (e.g., String, Integer, custom Object).
 */
public class Box<T> {
    
    // T stands for "Type"
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    // A Generic Method inside a Generic Class
    // The <U> declares a new type parameter specifically for this method
    public <U> void inspect(U someValue) {
        System.out.println("Box contains item of type: " + this.item.getClass().getSimpleName());
        System.out.println("Method received parameter of type: " + someValue.getClass().getSimpleName());
    }
}
