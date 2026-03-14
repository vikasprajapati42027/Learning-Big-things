class SuccessParent { String status = "GRADUATED"; }
class MasterStudent extends SuccessParent { }
public class SpringDataSummary {
    public static void main(String[] args) {
        System.out.println("Level: " + new MasterStudent().status);
    }
}
