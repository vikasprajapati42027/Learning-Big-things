package Test_java_leanring.test25;

/** test25 - Comparable */
public class Student implements Comparable<Student> {
    String name;
    int id;
    Student(String name, int id) { this.name = name; this.id = id; }
    @Override
    public int compareTo(Student o) { return Integer.compare(this.id, o.id); }
}
