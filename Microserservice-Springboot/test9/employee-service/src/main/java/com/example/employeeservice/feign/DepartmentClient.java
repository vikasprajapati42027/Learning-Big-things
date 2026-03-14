package com.example.employeeservice.feign;

import com.example.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * THE MAGIC INTERFACE:
 * You just define the method signature. 
 * Spring Cloud writes the logic to call DEPARTMENT-SERVICE for you!
 */
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("/departments/{id}")
    DepartmentDTO getDepartmentById(@PathVariable("id") Long id);
}
