package com.example.departmentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public Department department() {
        return departmentService.getDefaultDepartment();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from the Department service!";
    }
}
