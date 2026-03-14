/**
 * Interviewer: How to create a custom exception?
 * Candidate: Extend Exception (Checked) or RuntimeException (Unchecked).
 */
class AgeInvalidException extends Exception {
    public AgeInvalidException(String msg) { super(msg); }
}
public class Q4_Custom_Exception {
    void checkAge(int age) throws AgeInvalidException {
        if(age < 18) throw new AgeInvalidException("Too young");
    }
}
