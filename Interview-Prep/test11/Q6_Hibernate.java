/**
 * INTERVIEWER: Hibernate Topic 6.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
import java.util.*;

public class Q6_Hibernate {
    static class Query {
        private final String hql;

        Query(String hql) {
            this.hql = hql;
        }

        List<String> execute() {
            System.out.println("Executing query: " + hql);
            return Arrays.asList("Row1", "Row2");
        }
    }

    public static void main(String[] args) {
        Query query = new Query("FROM Customer WHERE active = true");
        query.execute().forEach(row -> System.out.println("Result: " + row));
    }
}
