public class User {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public User(String name) { this.name = name; }

    public void sendMessage(String message) {
        // Instead of talking to other users directly, talk to the Mediator!
        ChatRoom.showMessage(this, message);
    }
}
