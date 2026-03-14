/**
 * Interviewer: throw vs throws?
 * Candidate: throw triggers the exception. throws declares it in the method signature.
 */
public class Q5_Throw_vs_Throws {
    void a() throws Exception { throw new Exception("Error"); }
}
