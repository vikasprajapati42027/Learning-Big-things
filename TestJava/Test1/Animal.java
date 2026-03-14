package TestJava.Test1;

/**
 * 1. ABSTRACTION & ENCAPSULATION
 * 
 * Abstraction: This class is 'abstract' because you cannot create a generic "Animal".
 * You can only create specific animals like a Dog or Cat.
 */
public abstract class Animal {
    // 2. ENCAPSULATION
    // We make fields 'private' to protect them from direct outside access.
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public Getters and Setters: This is the ONLY way to access 'private' data.
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { if(age > 0) this.age = age; }

    // Abstract method: Every animal makes a sound, but it's DIFFERENT for each.
    // We force child classes to implement this logic.
    public abstract void makeSound();
}
