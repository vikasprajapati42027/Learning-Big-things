package Test_java_leanring.test91;

/** test91 - Copy constructor */
public class Person {
    String name;
    public Person(String name) { this.name = name; }
    public Person(Person other) { this.name = other.name; }
}
