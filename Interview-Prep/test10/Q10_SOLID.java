/**
 * INTERVIEWER: SOLID Principle Scenario 10.
 * CANDIDATE: Professional implementation of SOLID principle 10.
 */
class Audit {
    void log(String action) {
        System.out.println("Audit log: " + action);
    }
}

class Workflow {
    private final Audit audit;

    Workflow(Audit audit) {
        this.audit = audit;
    }

    void execute(String task) {
        audit.log("Starting " + task);
        System.out.println("Executing " + task);
        audit.log("Finished " + task);
    }
}

public class Q10_SOLID {
    public static void main(String[] args) {
        Workflow workflow = new Workflow(new Audit());
        workflow.execute("Approval Process");
    }
}
