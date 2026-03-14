package test2.department;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;
    public DepartmentController(DepartmentService service) { this.service = service; }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return service.getById(id);
    }
}
