/**
 * INTERVIEWER: SOLID Principle Scenario 5.
 * CANDIDATE: Professional implementation of SOLID principle 5.
 */
interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class ReportGenerator {
    private final NotificationService notificationService;

    ReportGenerator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void generateReport() {
        System.out.println("Report generated.");
        notificationService.send("Report is ready");
    }
}

public class Q5_SOLID {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator(new EmailNotification());
        generator.generateReport();
    }
}
