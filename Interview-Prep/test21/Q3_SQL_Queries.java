/**
 * Interviewer: Explain SQL_Queries Concept 3.
 * Candidate: Professional detailed answer regarding SQL_Queries 3.
 * 
 * Key Highlights: Joins, Subqueries, Aggregations
 */
public class Q3_SQL_Queries {
    public void demo() {
        System.out.println("SELECT status, COUNT(*) AS order_count");
        System.out.println("FROM orders");
        System.out.println("GROUP BY status;");
    }
}
