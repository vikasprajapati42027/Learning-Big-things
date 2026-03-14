package com.example.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

class UserCreatedEvent extends ApplicationEvent {
    private final String username;
    public UserCreatedEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
    public String getUsername() { return username; }
}

@Service
class UserService {
    private final org.springframework.context.ApplicationEventPublisher publisher;
    UserService(org.springframework.context.ApplicationEventPublisher p) { this.publisher = p; }

    public void createUser(String name) {
        System.out.println("User created: " + name);
        publisher.publishEvent(new UserCreatedEvent(this, name));
    }
}

@Component
public class WelcomeEmailListener {
    @EventListener
    public void onUserCreated(UserCreatedEvent event) {
        System.out.println("Sending welcome email to: " + event.getUsername());
    }
}
