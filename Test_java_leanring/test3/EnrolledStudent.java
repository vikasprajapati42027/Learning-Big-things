package Test_java_leanring.test3;

import Test_java_leanring.test1.Student;

public class EnrolledStudent extends Student implements Enrollable {
    private String course;

    public EnrolledStudent(String name, int rollNumber, String course) {
        super(name, rollNumber);
        this.course = course;
    }

    @Override
    public void enroll(String courseName) {
        this.course = courseName;
        System.out.println(getName() + " enrolled in: " + courseName);
    }

    public String getCourse() {
        return course;
    }
}
