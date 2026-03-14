public class BridgeDemo {
    public static void main(String[] args) {
        System.out.println("--- Testing with TV ---");
        TV tv = new TV();
        Remote basicRemote = new Remote(tv);
        basicRemote.togglePower();

        System.out.println("\n--- Testing with Radio & Advanced Remote ---");
        Radio radio = new Radio();
        AdvancedRemote advRemote = new AdvancedRemote(radio);
        advRemote.togglePower();
        advRemote.mute();
    }
}
