package TestJava.Test4;

/**
 * Implementation: SmartDevice
 * 
 * Even though we only say 'implements AdvancedControl', 
 * because AdvancedControl extends BasicControl, we are 
 * forced to implement on() and off() as well!
 */
public class SmartDevice implements AdvancedControl {

    @Override
    public void on() {
        System.out.println("SmartDevice: Powering ON... Blue light glowing.");
    }

    @Override
    public void off() {
        System.out.println("SmartDevice: Powering OFF... System standby.");
    }

    @Override
    public void setting(String mode) {
        System.out.println("SmartDevice: Changing mode to: " + mode);
    }
}
