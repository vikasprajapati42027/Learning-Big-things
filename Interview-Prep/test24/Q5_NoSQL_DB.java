/**
 * Interviewer: Explain NoSQL_DB Concept 5.
 * Candidate: Professional detailed answer regarding NoSQL_DB 5.
 * 
 * Key Highlights: MongoDB, Redis, Cassandra, DynamoDB
 */
public class Q5_NoSQL_DB {
    public void demo() {
        System.out.println("Code: db.sessions.createIndex({createdAt:1},{expireAfterSeconds:3600})");
        System.out.println("Query: db.sessions.find({userId:42})");
        System.out.println("Docker: docker run -d --name redis redis:7 redis-server --appendonly yes");
    }
}
