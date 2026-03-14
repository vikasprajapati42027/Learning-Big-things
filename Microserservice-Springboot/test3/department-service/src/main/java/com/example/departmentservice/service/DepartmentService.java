package com.example.departmentservice.service;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;
    public DepartmentService(DepartmentRepository repository) { this.repository = repository; }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
