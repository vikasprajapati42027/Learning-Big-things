package java_version.Java8_version.lambda.model;

/**
 * Student model – used in interview Q&A with List data.
 * Getter/setter for filter, aggregation, modification examples.
 */
public class Student {
    private int id;
    private String name;
    private String grade;
    private int marks;
    private String department;

    public Student(int id, String name, String grade, int marks, String department) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.marks = marks;
        this.department = department;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() { return name + "(" + grade + "," + marks + ")"; }
}
