class TimeParent { String format = "ISO"; }
class DateMapper extends TimeParent { }
public class TemporalDemo {
    public static void main(String[] args) { System.out.println("Format: " + new DateMapper().format); }
}
