package Test_java_leanring.test1;

/**
 * test1 - First concept: Class and Object
 * A class is a blueprint. Fields hold state, methods define behavior.
 */
public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void introduce() {
        System.out.println("I am " + name + ", roll number " + rollNumber + ".");
    }
}
