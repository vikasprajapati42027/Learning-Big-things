package com.example.departmentservice;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    public Department getDefaultDepartment() {
        return new Department(101, "Engineering");
    }
}
