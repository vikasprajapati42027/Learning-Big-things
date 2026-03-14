public class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) { super(device); }
    public void mute() {
        System.out.println("Remote: Muting device...");
        device.setVolume(0);
    }
}
