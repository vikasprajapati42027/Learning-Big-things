/**
 * INTERVIEWER: SOLID Principle Scenario 4.
 * CANDIDATE: Professional implementation of SOLID principle 4.
 */
interface Printable {
    void print(String document);
}

interface Scannable {
    void scan(String document);
}

class SimplePrinter implements Printable {
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

class MultiFunctionMachine implements Printable, Scannable {
    public void print(String document) {
        System.out.println("MFP printing: " + document);
    }

    public void scan(String document) {
        System.out.println("MFP scanning: " + document);
    }
}

public class Q4_SOLID {
    public static void main(String[] args) {
        Printable printer = new SimplePrinter();
        printer.print("Cover letter");

        MultiFunctionMachine mfp = new MultiFunctionMachine();
        mfp.print("Proposal");
        mfp.scan("Signed contract");
    }
}
