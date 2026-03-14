public class Radio implements Device {
    private boolean on = false;
    private int volume = 15;
    @Override public boolean isEnabled() { return on; }
    @Override public void enable() { on = true; System.out.println("Radio is ON"); }
    @Override public void disable() { on = false; System.out.println("Radio is OFF"); }
    @Override public void setVolume(int v) { this.volume = v; System.out.println("Radio Volume: " + v); }
}
