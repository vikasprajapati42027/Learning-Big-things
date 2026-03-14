package Test_java_leanring.test4;

/**
 * test4 - Abstract class: cannot instantiate, only extend.
 * Subclasses must implement abstract methods.
 */
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();
}
