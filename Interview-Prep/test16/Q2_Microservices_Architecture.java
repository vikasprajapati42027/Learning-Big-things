/**
 * Interviewer: Explain Microservices_Architecture Concept 2.
 * Candidate: Professional detailed answer regarding Microservices_Architecture 2.
 * 
 * Key Highlights: Independence, Scaling, Polyglot, Small Services
 */
public class Q2_Microservices_Architecture {
    public void demo() {
        System.out.println("Concept 2: Auto-scaling triggers scale-out.");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Scaling replica #" + i + " is healthy.");
        }
        System.out.println("Scaling decisions happen via metrics-driven controller.");
    }
}
