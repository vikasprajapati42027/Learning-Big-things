package TestJava.Test172;

import java.util.ArrayList;
import java.util.List;

// 1. The Command Interface
interface Command {
    void execute();
}

// 2. The Receiver (The actual object doing the work)
class Light {
    public void turnOn() { System.out.println("Light is ON"); }
    public void turnOff() { System.out.println("Light is OFF"); }
}

// 3. Concrete Commands (Encapsulating a specific action)
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

// 4. The Invoker (The remote control)
// It doesn't know anything about Lights! It just triggers Commands.
class RemoteControl {
    private List<Command> history = new ArrayList<>();

    public void submitCommand(Command cmd) {
        history.add(cmd);
        cmd.execute();
    }
    
    public void executeMacro() {
        System.out.println("--- Executing Entire Macro History! ---");
        for (Command c : history) {
            c.execute();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 172: Command Pattern ===\n");

        System.out.println("The Command Pattern encapsulates requests as objects.");
        System.out.println("It allows you to queue requests, log them, or support undo operations!\n");

        Light livingRoomLight = new Light();
        
        Command switchOn = new LightOnCommand(livingRoomLight);
        Command switchOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        
        System.out.println("User clicking buttons...");
        remote.submitCommand(switchOn);
        remote.submitCommand(switchOff);
        remote.submitCommand(switchOn);

        System.out.println();
        remote.executeMacro();
    }
}
