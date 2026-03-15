/**
 * Interviewer: Explain SQL_Queries Concept 5.
 * Candidate: Professional detailed answer regarding SQL_Queries 5.
 * 
 * Key Highlights: Joins, Subqueries, Aggregations
 */
public class Q5_SQL_Queries {
    public void demo() {
        System.out.println("SELECT customer_id, SUM(amount) AS total_spent");
        System.out.println("FROM invoices");
        System.out.println("GROUP BY customer_id");
        System.out.println("HAVING SUM(amount) > 1000;");
    }
}
