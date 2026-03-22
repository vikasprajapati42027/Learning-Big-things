package com.example.urlshortener.service;

import com.example.urlshortener.dto.CreateEmployeeRequest;
import com.example.urlshortener.dto.EmployeeResponse;
import com.example.urlshortener.dto.UpdateEmployeeRequest;
import com.example.urlshortener.model.Employee;
import com.example.urlshortener.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EmployeeResponse create(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setEmail(request.email());
        employee.setDepartment(request.department());
        Employee saved = repository.save(employee);
        return toResponse(saved);
    }

    public List<EmployeeResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public Optional<EmployeeResponse> get(Long id) {
        return repository.findById(id).map(this::toResponse);
    }

    @Transactional
    public Optional<EmployeeResponse> update(Long id, UpdateEmployeeRequest request) {
        return repository.findById(id).map(existing -> {
            existing.setName(request.name());
            existing.setEmail(request.email());
            existing.setDepartment(request.department());
            return toResponse(repository.save(existing));
        });
    }

    @Transactional
    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    private EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getCreatedAt());
    }
}
