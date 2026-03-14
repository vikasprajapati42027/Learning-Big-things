package test2.employee;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeService {
    private final RestTemplate restTemplate = new RestTemplate();
    private Map<Long, Employee> db = new ConcurrentHashMap<>();

    public EmployeeService() {
        db.put(101L, new Employee(101L, "Vikas", 1L));
    }

    public EmployeeResponse getEmployeeWithDept(Long id) {
        Employee emp = db.get(id);
        
        // Calling Department microservice
        String url = "http://localhost:8081/departments/" + emp.getDepartmentId();
        DepartmentDTO dept = restTemplate.getForObject(url, DepartmentDTO.class);
        
        return new EmployeeResponse(emp, dept);
    }
}
