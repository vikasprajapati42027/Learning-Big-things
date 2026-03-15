/**
 * Interviewer: Explain SQL_ACID Concept 5.
 * Candidate: Professional detailed answer regarding SQL_ACID 5.
 * 
 * Key Highlights: Atomicity, Consistency, Isolation, Durability
 */
public class Q5_SQL_ACID {
    public void demo() {
        System.out.println("Use savepoints to rollback partial work while keeping earlier steps.");
        System.out.println("Savepoint S1; work; if failure rollback to S1 and reattempt.");
    }
}
