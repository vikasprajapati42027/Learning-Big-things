package com.example.eventsourcing;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventStoreService eventStore;

    public EventController(EventStoreService eventStore) {
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public String create(@RequestParam String data) {
        eventStore.addEvent("CREATED: " + data);
        return "Event stored!";
    }

    @PostMapping("/update")
    public String update(@RequestParam String data) {
        eventStore.addEvent("UPDATED: " + data);
        return "Change stored!";
    }

    @GetMapping("/history")
    public List<String> getHistory() {
        return eventStore.getEvents();
    }

    @GetMapping("/state")
    public String getState() {
        return "Current State: " + eventStore.getCurrentState();
    }
}
