package com.example.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DataController {
    private final DataRepository repository;

    public DataController(DataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/data")
    public List<ServiceData> getData() {
        return repository.findAll();
    }
}
