package com.example.versioning;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class VersionedEmployeeController {

    // V1: Classic approach
    @GetMapping("/v1")
    public List<String> getEmployeesV1() {
        return List.of("Vikas (Senior)", "Rahul (Junior)");
    }

    // V2: New approach (adds more data)
    @GetMapping("/v2")
    public List<EmployeeV2> getEmployeesV2() {
        return List.of(
            new EmployeeV2(1L, "Vikas", "Architect"),
            new EmployeeV2(2L, "Rahul", "Developer")
        );
    }
}

class EmployeeV2 {
    private Long id;
    private String name;
    private String role;

    public EmployeeV2(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    // Getters...
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
}
