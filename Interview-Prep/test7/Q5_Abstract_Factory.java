/**
 * Interviewer: Abstract Factory vs Factory Method?
 * Candidate: Factory creates one product. Abstract Factory creates families of related products.
 */
interface OS { void run(); }
class Windows implements OS { public void run() { System.out.println("Win 11"); } }
class MacOS implements OS { public void run() { System.out.println("Mac Sequoia"); } }

interface Processor { void process(); }
class Intel implements Processor { public void process() { System.out.println("i9"); } }
class AppleSilicon implements Processor { public void process() { System.out.println("M3"); } }

interface PCFactory {
    OS createOS();
    Processor createProcessor();
}

class AppleFactory implements PCFactory {
    public OS createOS() { return new MacOS(); }
    public Processor createProcessor() { return new AppleSilicon(); }
}

public class Q5_Abstract_Factory {
    public static void main(String[] args) {
        PCFactory factory = new AppleFactory();
        factory.createOS().run();
        factory.createProcessor().process();
    }
}
