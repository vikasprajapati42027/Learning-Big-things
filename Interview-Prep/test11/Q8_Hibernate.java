/**
 * INTERVIEWER: Hibernate Topic 8.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
public class Q8_Hibernate {
    static class Transaction {
        void begin() {
            System.out.println("Transaction started.");
        }

        void commit() {
            System.out.println("Transaction committed.");
        }

        void rollback() {
            System.out.println("Transaction rolled back.");
        }
    }

    static class Service {
        private final Transaction transaction;

        Service(Transaction transaction) {
            this.transaction = transaction;
        }

        void doWork() {
            transaction.begin();
            try {
                System.out.println("Performing work within transaction.");
                transaction.commit();
            } catch (RuntimeException ex) {
                transaction.rollback();
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service(new Transaction());
        service.doWork();
    }
}
