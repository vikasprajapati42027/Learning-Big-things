package Test8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA is magic! 
 * By extending JpaRepository, Spring automatically creates the implementation 
 * for common database operations like save, delete, findById, etc.
 * 
 * We specify <User, Long>: 
 * - User: The Entity type.
 * - Long: The type of the ID (@Id) field.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can also add custom query methods like:
    // List<User> findByName(String name);
}
