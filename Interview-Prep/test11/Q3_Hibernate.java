/**
 * INTERVIEWER: Hibernate Topic 3.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
import java.util.*;

public class Q3_Hibernate {
    static class Customer {
        private final Long id;
        private final String name;

        Customer(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{id=" + id + ", name='" + name + "'}";
        }
    }

    static class Repository {
        private final Map<Long, Customer> store = new HashMap<>();

        void save(Customer customer) {
            store.put(customer.id, customer);
            System.out.println("Saved: " + customer);
        }

        Optional<Customer> find(Long id) {
            return Optional.ofNullable(store.get(id));
        }
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        Customer customer = new Customer(501L, "Nimbus Ltd");
        repository.save(customer);
        repository.find(501L).ifPresent(c -> System.out.println("Fetched: " + c));
    }
}
