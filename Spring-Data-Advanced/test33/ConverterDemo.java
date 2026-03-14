class MapParent { String to = "VARCHAR"; }
class ListConverter extends MapParent { }
public class ConverterDemo {
    public static void main(String[] args) { System.out.println("Data To: " + new ListConverter().to); }
}
