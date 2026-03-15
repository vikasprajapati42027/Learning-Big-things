/**
 * Interviewer: Explain SQL_Queries Concept 4.
 * Candidate: Professional detailed answer regarding SQL_Queries 4.
 * 
 * Key Highlights: Joins, Subqueries, Aggregations
 */
public class Q4_SQL_Queries {
    public void demo() {
        System.out.println("SELECT id, customer_id, amount,");
        System.out.println("SUM(amount) OVER (PARTITION BY customer_id ORDER BY payment_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS running_total");
        System.out.println("FROM payments;");
    }
}
