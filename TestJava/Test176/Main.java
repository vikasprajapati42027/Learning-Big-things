package TestJava.Test176;

import java.util.ArrayList;
import java.util.List;

// 1. Mediator Interface
interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

// 2. Concrete Mediator (The Hub)
class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender) {
        for (User u : users) {
             // message should not be received by the user sending it
            if (u != sender) {
                u.receive(msg);
            }
        }
    }
}

// 3. Colleague Interface
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

// 4. Concrete Colleagues
class ChatUser extends User {
    public ChatUser(ChatMediator med, String name) { super(med, name); }

    @Override
    public void send(String msg) {
        System.out.println(this.name + " sends: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " receives: " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 176: Mediator Pattern ===\n");

        System.out.println("Reduces chaotic dependencies between objects by forcing them to communicate");
        System.out.println("via a central Mediator object (like an Air Traffic Controller or Chat Room)!\n");

        ChatMediator mediator = new ChatRoom();
        
        User user1 = new ChatUser(mediator, "Vikas");
        User user2 = new ChatUser(mediator, "Alice");
        User user3 = new ChatUser(mediator, "Bob");
        User user4 = new ChatUser(mediator, "Dave");
        
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        
        user1.send("Hi Everyone!");
    }
}
