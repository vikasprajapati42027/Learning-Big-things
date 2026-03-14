package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDTO;
import com.example.employeeservice.dto.ResponseDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final RestTemplate restTemplate;

    public EmployeeService(EmployeeRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public ResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = repository.findById(employeeId).get();
        
        // --- THE ADVANCED CALL (SERVICE DISCOVERY) ---
        // Notice we don't use 'localhost:8081'. 
        // We use the application name 'DEPARTMENT-SERVICE'!
        DepartmentDTO departmentDTO = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId(),
                DepartmentDTO.class);

        return new ResponseDTO(employee, departmentDTO);
    }
}
