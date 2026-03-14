class StreamParent { void open() { System.out.println("DB Stream Open"); } }
class DataStream extends StreamParent { }
public class StreamDataDemo {
    public static void main(String[] args) { new DataStream().open(); }
}
