/**
 * INTERVIEWER: Hibernate Topic 10.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
import java.time.*;

public class Q10_Hibernate {
    static class AuditLog {
        void record(String entity, String action) {
            System.out.println(Instant.now() + " AUDIT " + entity + " => " + action);
        }
    }

    static class AuditedEntity {
        private final String name;
        private final AuditLog auditLog;

        AuditedEntity(String name, AuditLog auditLog) {
            this.name = name;
            this.auditLog = auditLog;
        }

        void update(String newName) {
            auditLog.record(name, "before update");
            System.out.println("Updating entity from " + name + " to " + newName);
            auditLog.record(newName, "after update");
        }
    }

    public static void main(String[] args) {
        AuditedEntity entity = new AuditedEntity("Career", new AuditLog());
        entity.update("CareerEnhanced");
    }
}
