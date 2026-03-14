package java_version.Java8_version.lambda.data;

public class Student {
    private int id;
    private String name;
    private String grade;  // e.g. "A", "B", "C"
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
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public int getMarks() { return marks; }
    public String getDepartment() { return department; }

    @Override
    public String toString() { return name + "(" + grade + "," + marks + ")"; }
}
