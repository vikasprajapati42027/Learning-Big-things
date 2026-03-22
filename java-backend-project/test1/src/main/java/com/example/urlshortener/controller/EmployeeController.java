package com.example.urlshortener.controller;

import com.example.urlshortener.dto.CreateEmployeeRequest;
import com.example.urlshortener.dto.EmployeeResponse;
import com.example.urlshortener.dto.UpdateEmployeeRequest;
import com.example.urlshortener.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody CreateEmployeeRequest request) {
        EmployeeResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/api/v1/employees/" + created.id())).body(created);
    }

    @GetMapping
    public List<EmployeeResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> get(@PathVariable Long id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {
        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
