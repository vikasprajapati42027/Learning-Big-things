/**
 * INTERVIEWER: Explain the CAP Theorem.
 * 
 * CANDIDATE: It states that a distributed system can only provide two out of 
 * three guarantees: Consistency, Availability, and Partition Tolerance.
 * 
 * PROPER EXPLANATION:
 * 1. Consistency: Every read receives the most recent write.
 * 2. Availability: Every request receives a (non-error) response.
 * 3. Partition Tolerance: System continues to operate despite network failures.
 * 4. Fact: In a distributed system, network failure (P) is inevitable. You must choose C or A.
 */

public class Q2_CAP_Theorem {
    public static void main(String[] args) {
        System.out.println("CAP Choices:");
        System.out.println("CP: Consistency + Partition Tolerance (e.g., MongoDB, Redis)");
        System.out.println("AP: Availability + Partition Tolerance (e.g., Cassandra, DynamoDB)");
    }
}
