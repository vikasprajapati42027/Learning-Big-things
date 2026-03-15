/**
 * Interviewer: Explain SQL_Queries Concept 2.
 * Candidate: Professional detailed answer regarding SQL_Queries 2.
 * 
 * Key Highlights: Joins, Subqueries, Aggregations
 */
public class Q2_SQL_Queries {
    public void demo() {
        System.out.println("SELECT o.*");
        System.out.println("FROM orders o");
        System.out.println("WHERE o.customer_id IN (SELECT id FROM customers WHERE vip = true);");
    }
}
