package com.example.eventsourcing;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventStoreService {
    private final List<String> eventLog = new ArrayList<>();

    public void addEvent(String event) {
        eventLog.add(event);
    }

    public List<String> getEvents() {
        return eventLog;
    }

    public String getCurrentState() {
        // Simple replay logic
        return eventLog.stream().collect(Collectors.joining(" -> "));
    }
}
