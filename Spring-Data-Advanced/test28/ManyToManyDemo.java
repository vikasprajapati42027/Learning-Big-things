class JoinParent { String table = "JOIN_TABLE"; }
class StudentCourse extends JoinParent { }
public class ManyToManyDemo {
    public static void main(String[] args) { System.out.println("Mapping: " + new StudentCourse().table); }
}
