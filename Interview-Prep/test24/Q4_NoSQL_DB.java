/**
 * Interviewer: Explain NoSQL_DB Concept 4.
 * Candidate: Professional detailed answer regarding NoSQL_DB 4.
 * 
 * Key Highlights: MongoDB, Redis, Cassandra, DynamoDB
 */
public class Q4_NoSQL_DB {
    public void demo() {
        System.out.println("Code: db.payments.updateOne({id:100},{ $set:{status:'processed'}})");
        System.out.println("Query: db.payments.find({status:'processed'})");
        System.out.println("Docker: docker exec -it mongo mongo --eval 'use payments'");
    }
}
