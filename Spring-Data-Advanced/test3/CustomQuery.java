import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface MyRepo {
    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain")
    java.util.List<User> findByEmailDomain(@Param("domain") String domain);
}
