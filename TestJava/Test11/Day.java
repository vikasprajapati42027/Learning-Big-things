package TestJava.Test11;

/**
 * An Enum (Enumeration) is a special "class" that represents a group of constants.
 * It's powerful because it can have fields, constructors, and methods, unlike in C/C++.
 */
public enum Day {
    MONDAY("Work Day"),
    TUESDAY("Work Day"),
    WEDNESDAY("Work Day"),
    THURSDAY("Work Day"),
    FRIDAY("Work Day"),
    SATURDAY("Weekend"),
    SUNDAY("Weekend");

    private final String type;

    // Enum constructor is always private
    Day(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
