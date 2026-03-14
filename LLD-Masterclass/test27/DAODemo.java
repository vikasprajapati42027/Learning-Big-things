public class DAODemo {
    public static void main(String[] args) {
        StudentDAO studentDao = new StudentDAOImpl();

        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        Student student = studentDao.getAllStudents().get(0);
        student.setName("Vikas Updated");
        studentDao.updateStudent(student);
    }
}
