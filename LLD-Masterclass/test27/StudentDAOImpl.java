import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    List<Student> students;

    public StudentDAOImpl() {
        students = new ArrayList<Student>();
        students.add(new Student("Vikas", 0));
        students.add(new Student("Amit", 1));
    }

    @Override
    public List<Student> getAllStudents() { return students; }

    @Override
    public Student getStudent(int rollNo) { return students.get(rollNo); }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student Roll No " + student.getRollNo() + " updated in database.");
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Student Roll No " + student.getRollNo() + " deleted from database.");
    }
}
