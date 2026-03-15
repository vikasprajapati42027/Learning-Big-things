/**
 * Interviewer: Explain SQL_Queries Concept 6.
 * Candidate: Professional detailed answer regarding SQL_Queries 6.
 * 
 * Key Highlights: Joins, Subqueries, Aggregations
 */
public class Q6_SQL_Queries {
    public void demo() {
        System.out.println("BEGIN TRANSACTION;");
        System.out.println("UPDATE accounts SET balance = balance - 100 WHERE id = 1;");
        System.out.println("UPDATE accounts SET balance = balance + 100 WHERE id = 2;");
        System.out.println("COMMIT;");
    }
}
