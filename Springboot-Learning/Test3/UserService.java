package Test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Service is a specialization of @Component.
 * It is used for the Business Logic Layer.
 * It's where you put your main application logic, calculations, and rules.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<String> getProcessedUserNames() {
        // Business Logic: Get users and convert them to uppercase
        return userRepository.findAllUsers().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
