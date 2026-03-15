/**
 * INTERVIEWER: Hibernate Topic 9.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
import java.util.*;

public class Q9_Hibernate {
    static class CriteriaBuilder {
        private final List<String> predicates = new ArrayList<>();

        CriteriaBuilder where(String predicate) {
            predicates.add(predicate);
            return this;
        }

        List<String> build() {
            return Collections.unmodifiableList(predicates);
        }
    }

    public static void main(String[] args) {
        CriteriaBuilder builder = new CriteriaBuilder()
            .where("status = 'ACTIVE'")
            .where("balance > 0");
        System.out.println("Criteria predicates: " + builder.build());
    }
}
