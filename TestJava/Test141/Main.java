package TestJava.Test141;

// Product Interface
interface Notification {
    void notifyUser();
}

// Concrete Products
class SMSNotification implements Notification {
    public void notifyUser() { System.out.println("Sending SMS Notification..."); }
}

class EmailNotification implements Notification {
    public void notifyUser() { System.out.println("Sending Email Notification..."); }
}

class PushNotification implements Notification {
    public void notifyUser() { System.out.println("Sending Push Notification..."); }
}

// The Factory Class
class NotificationFactory {
    
    // The Factory Method
    // We can change the creation logic here without touching the client code!
    public static Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) return null;
        
        return switch (channel.toUpperCase()) {
            case "SMS" -> new SMSNotification();
            case "EMAIL" -> new EmailNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown channel: " + channel);
        };
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Pattern: Factory Method ===\n");

        System.out.println("The Factory creates objects WITHOUT exposing the instantiation logic to the client.");
        System.out.println("Instead of 'new SMSNotification()', we ask the factory to give us an 'SMS'.\n");

        // Client Code: We don't care HOW the notification is built. We just use the interface.
        
        Notification notif1 = NotificationFactory.createNotification("SMS");
        notif1.notifyUser();
        
        Notification notif2 = NotificationFactory.createNotification("EMAIL");
        notif2.notifyUser();
        
        Notification notif3 = NotificationFactory.createNotification("PUSH");
        notif3.notifyUser();
    }
}
