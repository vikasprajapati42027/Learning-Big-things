package Test16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Integration Testing (Slicing):
 * @DataJpaTest focuses only on the Data layer. 
 * It starts an in-memory database (like H2), configures Hibernate, 
 * and scans for @Entity classes.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example of an Integration Test class (Simulated)
 * 
 * @DataJpaTest
 * class UserRepositoryTest {
 *     @Autowired
 *     private UserRepository repository;
 * 
 *     @Test
 *     void testSave() {
 *         User user = new User("Vikas", "v@v.com");
 *         repository.save(user);
 *         assertThat(repository.count()).isEqualTo(1);
 *     }
 * }
 */
