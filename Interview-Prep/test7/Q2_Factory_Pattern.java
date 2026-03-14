/**
 * Interviewer: Explain the Factory Pattern.
 * Candidate: It defines an interface for creating an object but lets subclasses decide which class to instantiate.
 */
interface Notification { void notifyUser(); }
class Email implements Notification { public void notifyUser() { System.out.println("Sending Email..."); } }
class SMS implements Notification { public void notifyUser() { System.out.println("Sending SMS..."); } }

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null) return null;
        if (type.equals("EMAIL")) return new Email();
        if (type.equals("SMS")) return new SMS();
        return null;
    }
}

public class Q2_Factory_Pattern {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification note = factory.createNotification("EMAIL");
        note.notifyUser();
    }
}
