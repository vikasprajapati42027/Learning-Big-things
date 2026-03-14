/**
 * Interviewer: What is Singleton?
 * Candidate: A class that has only one instance and provides global access.
 */
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }
}
public class Q1_Singleton_Pattern { }
