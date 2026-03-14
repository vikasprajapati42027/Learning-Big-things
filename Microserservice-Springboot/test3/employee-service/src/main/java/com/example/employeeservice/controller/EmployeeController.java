package com.example.employeeservice.controller;

import com.example.employeeservice.dto.ResponseDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseDTO getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }
}
