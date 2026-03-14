package TestJava.Test143;

import java.util.ArrayList;
import java.util.List;

// 1. The Observer Interface
interface Observer {
    void update(String videoTitle);
}

// 2. Concrete Observers (The Subscribers)
class RegularSubscriber implements Observer {
    private String name;
    public RegularSubscriber(String name) { this.name = name; }
    
    @Override
    public void update(String videoTitle) {
        System.out.println("[App Notification] " + name + " -> New Video Uploaded: " + videoTitle);
    }
}

class PremiumSubscriber implements Observer {
    private String name;
    public PremiumSubscriber(String name) { this.name = name; }
    
    @Override
    public void update(String videoTitle) {
        System.out.println("[SMS Alert] " + name + " -> Watch it ad-free now: " + videoTitle);
    }
}

// 3. The Subject (The Publisher)
class YouTubeChannel {
    private List<Observer> subscribers = new ArrayList<>();
    private String channelName;

    public YouTubeChannel(String channelName) { this.channelName = channelName; }

    public void subscribe(Observer ob) {
        subscribers.add(ob);
    }

    public void unsubscribe(Observer ob) {
        subscribers.remove(ob);
    }

    // This is the core of the pattern! Notify all registered observers dynamically.
    public void uploadVideo(String title) {
        System.out.println("\n>>> Channel '" + channelName + "' uploaded: " + title);
        for (Observer sub : subscribers) {
            sub.update(title);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Pattern: Observer ===\n");

        // The Observer pattern defines a one-to-many dependency.
        // When the Subject changes state (uploads a video), all Observers are notified automatically!

        YouTubeChannel techChannel = new YouTubeChannel("TechWithVikas");

        Observer alice = new RegularSubscriber("Alice");
        Observer bob = new PremiumSubscriber("Bob");

        // Subscribing to the channel
        techChannel.subscribe(alice);
        techChannel.subscribe(bob);

        // Uploading a video triggers the notifications!
        techChannel.uploadVideo("Java 21 New Features!");

        // Alice decides to unsubscribe
        techChannel.unsubscribe(alice);

        // Uploading another video
        techChannel.uploadVideo("Spring Boot 3 Masterclass");
    }
}
