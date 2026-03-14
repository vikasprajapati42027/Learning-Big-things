package Test_java_leanring.test44;

/** test44 - Generics (generic class) */
public class Box<T> {
    private T value;
    public void set(T v) { value = v; }
    public T get() { return value; }
}
