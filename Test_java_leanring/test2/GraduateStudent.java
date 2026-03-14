package Test_java_leanring.test2;

import Test_java_leanring.test1.Student;

/**
 * test2 - Inheritance: GraduateStudent extends Student.
 * Gets name, rollNumber, introduce() from Student and adds its own field/behavior.
 */
public class GraduateStudent extends Student {
    private String thesisTopic;

    public GraduateStudent(String name, int rollNumber, String thesisTopic) {
        super(name, rollNumber);
        this.thesisTopic = thesisTopic;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    @Override
    public void introduce() {
        System.out.println("I am " + getName() + ", roll " + getRollNumber()
                + ", graduate. Thesis: " + thesisTopic + ".");
    }
}
