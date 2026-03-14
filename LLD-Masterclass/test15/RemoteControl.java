public class RemoteControl {
    private Command slot;
    public void setCommand(Command command) { slot = command; }
    public void pressButton() { slot.execute(); }
}
