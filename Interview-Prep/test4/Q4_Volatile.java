/**
 * Interviewer: volatile keyword?
 * Candidate: It forces threads to read the variable from MAIN RAM instead of their CPU Cache (Visibility).
 */
public class Q4_Volatile {
    private volatile boolean flag = true;
}
