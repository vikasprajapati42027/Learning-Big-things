/**
 * Interviewer: Explain SQL_Queries Concept 1.
 * Candidate: Professional detailed answer regarding SQL_Queries 1.
 * 
 * Key Highlights: Joins, Subqueries, Aggregations
 */
public class Q1_SQL_Queries {
    public void demo() {
        System.out.println("SELECT o.id, o.order_date, c.name");
        System.out.println("FROM orders o");
        System.out.println("JOIN customers c ON o.customer_id = c.id");
        System.out.println("WHERE o.status = 'shipped';");
    }
}
