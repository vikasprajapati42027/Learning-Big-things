package Test_java_leanring.test4;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public String getRole() {
        return "Teacher of " + subject;
    }
}
