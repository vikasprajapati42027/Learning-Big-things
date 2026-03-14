/**
 * Interviewer: Does catch block order matter?
 * Candidate: Yes. Specialized exceptions must come BEFORE parent Exception class.
 */
public class Q6_Catch_Order {
    void demo() {
        try { }
        catch(NullPointerException e) { }
        catch(Exception e) { } // Must be last
    }
}
