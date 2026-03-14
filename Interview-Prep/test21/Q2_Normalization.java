/**
 * INTERVIEWER: Explain Database Normalization (1NF, 2NF, 3NF).
 * 
 * CANDIDATE: Normalization is the process of organizing data to reduce redundancy 
 * and improve data integrity.
 * 
 * PROPER EXPLANATION:
 * 1. 1NF: Atomic values, no repeating groups.
 * 2. 2NF: 1NF + All non-key attributes must depend on the whole primary key.
 * 3. 3NF: 2NF + No transitive dependencies (attribute depends on another non-key attribute).
 * 4. Trade-off: Normalization improves integrity; De-normalization (e.g., in Data Warehousing) improves read speed.
 */

public class Q2_Normalization {
    public static void main(String[] args) {
        System.out.println("Normalization Guidelines:");
        System.out.println("1NF: No arrays/lists in columns.");
        System.out.println("2NF: Remove partial functional dependencies.");
        System.out.println("3NF: Remove transitive functional dependencies.");
    }
}
