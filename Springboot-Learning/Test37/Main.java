package Test37;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transaction Management:
 * Ensures "All or Nothing" execution. 
 * If one step fails, the whole set of database changes is rolled back.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Service
class BankService {

    /**
     * @Transactional makes this method atomic.
     */
    @Transactional
    public void transferMoney(Long fromId, Long toId, double amount) {
        // 1. Subtract from A
        // 2. Add to B
        
        // If an exception happens here, 
        // the subtraction from A is undone automatically!
        if (amount > 100000) {
            throw new RuntimeException("Suspicious activity detected! Rollback.");
        }
    }
}
