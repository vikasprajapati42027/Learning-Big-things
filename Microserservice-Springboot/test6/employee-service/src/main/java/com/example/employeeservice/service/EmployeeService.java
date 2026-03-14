package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDTO;
import com.example.employeeservice.dto.ResponseDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    /**
     * @CircuitBreaker:
     * If 'DEPARTMENT-SERVICE' is down, this method will fail.
     * Instead of returning an error, it will call 'dummyDepartment'.
     */
    @CircuitBreaker(name = "employeeService", fallbackMethod = "dummyDepartment")
    public ResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = repository.findById(employeeId).get();
        
        DepartmentDTO departmentDTO = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId(),
                DepartmentDTO.class);

        return new ResponseDTO(employee, departmentDTO);
    }

    // FALLBACK METHOD
    // Must have the same signature + an Exception parameter
    public ResponseDTO dummyDepartment(Long employeeId, Exception e) {
        System.out.println(">>> Circuit Breaker Triggered! Getting dummy data.");
        Employee employee = repository.findById(employeeId).get();
        
        DepartmentDTO dummyDept = new DepartmentDTO();
        dummyDept.setDepartmentName("Service Unavailable");
        dummyDept.setDepartmentCode("ERROR-503");
        
        return new ResponseDTO(employee, dummyDept);
    }
}
