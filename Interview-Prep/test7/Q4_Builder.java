/**
 * Interviewer: Why use Builder?
 * Candidate: To construct complex objects with many optional parameters step-by-step.
 */
class Computer {
    private String hdd, ram;
    public static class Builder {
        private String hdd, ram;
        public Builder hdd(String val) { hdd = val; return this; }
        public Builder ram(String val) { ram = val; return this; }
        public Computer build() { return new Computer(); }
    }
}
public class Q4_Builder { }
