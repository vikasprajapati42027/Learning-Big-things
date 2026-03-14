package Test3;

import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

/**
 * @Repository is a specialization of @Component.
 * It is used for the Data Access Layer (DAO).
 * It tells Spring that this class is responsible for communicating with a database.
 */
@Repository
public class UserRepository {

    public List<String> findAllUsers() {
        // Simulating fetching data from a database
        return Arrays.asList("Alice", "Bob", "Charlie");
    }
}
