import org.springframework.data.jpa.repository.JpaRepository;
public interface MyRepository extends JpaRepository<Object, Long> {
    // Advanced persistence logic for test20
}
