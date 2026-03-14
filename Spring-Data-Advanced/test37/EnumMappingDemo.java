class EnumParent { String type = "STRING"; }
class StatusMapper extends EnumParent { }
public class EnumMappingDemo {
    public static void main(String[] args) { System.out.println("Mapped as: " + new StatusMapper().type); }
}
