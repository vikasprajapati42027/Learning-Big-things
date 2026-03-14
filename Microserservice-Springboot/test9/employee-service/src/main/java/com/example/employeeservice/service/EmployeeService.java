package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDTO;
import com.example.employeeservice.dto.ResponseDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.feign.DepartmentClient;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final DepartmentClient departmentClient; // Using Feign instead of RestTemplate

    public EmployeeService(EmployeeRepository repository, DepartmentClient departmentClient) {
        this.repository = repository;
        this.departmentClient = departmentClient;
    }

    public ResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = repository.findById(employeeId).get();
        
        // --- NEW CLEAN WAY TO CALL ---
        // Just call the interface method! No URLs, no Strings.
        DepartmentDTO departmentDTO = departmentClient.getDepartmentById(employee.getDepartmentId());

        return new ResponseDTO(employee, departmentDTO);
    }
}
