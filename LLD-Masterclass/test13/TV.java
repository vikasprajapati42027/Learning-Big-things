public class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    @Override public boolean isEnabled() { return on; }
    @Override public void enable() { on = true; System.out.println("TV is ON"); }
    @Override public void disable() { on = false; System.out.println("TV is OFF"); }
    @Override public void setVolume(int v) { this.volume = v; System.out.println("TV Volume: " + v); }
}
