public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    void setVolume(int percent);
}
