package TestJava.Test24;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
        System.out.println("Person created: " + this.name);
    }

    public String getName() {
        return name;
    }

    // A static method to demonstrate static method references
    public static int compareByNameLength(Person p1, Person p2) {
        return Integer.compare(p1.getName().length(), p2.getName().length());
    }

    @Override
    public String toString() {
        return "Person[" + name + "]";
    }
}
