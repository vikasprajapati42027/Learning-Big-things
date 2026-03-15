/**
 * Interviewer: Explain NoSQL_DB Concept 8.
 * Candidate: Professional detailed answer regarding NoSQL_DB 8.
 * 
 * Key Highlights: MongoDB, Redis, Cassandra, DynamoDB
 */
public class Q8_NoSQL_DB {
    public void demo() {
        System.out.println("Code: session.startTransaction(); // multi-document update");
        System.out.println("Query: db.transactions.updateMany({status:'pending'},{ $set:{status:'complete'}})");
        System.out.println("Docker: docker run -d --name mongo-multi mongo:6");
    }
}
