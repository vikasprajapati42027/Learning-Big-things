public class Remote {
    protected Device device;
    public Remote(Device device) { this.device = device; }
    public void togglePower() {
        if (device.isEnabled()) device.disable();
        else device.enable();
    }
    public void volumeDown() { device.setVolume(10); }
    public void volumeUp() { device.setVolume(50); }
}
