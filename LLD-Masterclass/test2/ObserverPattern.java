import java.util.*;

interface Observer { void update(String msg); }

class User implements Observer {
    String name;
    public User(String n) { name = n; }
    public void update(String msg) { System.out.println(name + " received: " + msg); }
}

class YoutubeChannel {
    private List<Observer> subscribers = new ArrayList<>();
    public void subscribe(Observer u) { subscribers.add(u); }
    public void uploadVideo(String title) {
        for(Observer u : subscribers) u.update("New Video: " + title);
    }
}
