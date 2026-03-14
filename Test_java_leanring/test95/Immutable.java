package Test_java_leanring.test95;

/** test95 - Immutable class (final class, final fields, no setters) */
public final class Immutable {
    private final int value;
    public Immutable(int value) { this.value = value; }
    public int getValue() { return value; }
}
