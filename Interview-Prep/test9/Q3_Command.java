/**
 * INTERVIEWER: Explain the Command Pattern.
 * CANDIDATE: It encapsulates a request as an object, allowing us to parameterize clients with different requests.
 */
interface Command { void execute(); }
class Light { void on() { System.out.println("Light is ON"); } }
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light l) { this.light = l; }
    public void execute() { light.on(); }
}
class RemoteControl {
    private Command slot;
    public void setCommand(Command c) { slot = c; }
    public void pressButton() { slot.execute(); }
}
public class Q3_Command {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();
    }
}
