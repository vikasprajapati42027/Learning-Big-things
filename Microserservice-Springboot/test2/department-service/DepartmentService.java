package test2.department;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DepartmentService {
    private Map<Long, Department> db = new ConcurrentHashMap<>();

    public DepartmentService() {
        db.put(1L, new Department(1L, "IT", "New York"));
        db.put(2L, new Department(2L, "HR", "London"));
    }

    public Department getById(Long id) {
        return db.get(id);
    }
}
