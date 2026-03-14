package TestJava.Test178;

// 1. Abstract Class (The Template!)
// Note: It is vital that the template method itself is `final` so subclasses cannot change the core algorithm!
abstract class DataMiner {
    
    // The Template Method! Defines the skeleton of the algorithm.
    public final void mineData() {
        openFile();
        extractData();
        parseData();
        analyzeData();
        sendReport();
        closeFile();
    }

    // Default implementations shared by all subclasses
    private void analyzeData() { System.out.println("Default Analysis: Crunching numbers..."); }
    private void sendReport() { System.out.println("Default action: Emailing report to admin."); }

    // Abstract methods that MUST be implemented by subclasses (Steps that vary!)
    protected abstract void openFile();
    protected abstract void extractData();
    protected abstract void parseData();
    protected abstract void closeFile();
}

// 2. Concrete Implementations
class PDFDataMiner extends DataMiner {
    protected void openFile() { System.out.println("Opening PDF file with Adobe Reader..."); }
    protected void extractData() { System.out.println("Extracting text from PDF images via OCR..."); }
    protected void parseData() { System.out.println("Parsing PDF objects..."); }
    protected void closeFile() { System.out.println("Closing PDF file.\n"); }
}

class CSVDataMiner extends DataMiner {
    protected void openFile() { System.out.println("Opening CSV file with Scanner..."); }
    protected void extractData() { System.out.println("Reading Comma Separated lines..."); }
    protected void parseData() { System.out.println("Parsing CSV columns into Objects..."); }
    protected void closeFile() { System.out.println("Closing CSV file.\n"); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 178: Template Method Pattern ===\n");

        System.out.println("Defines the skeleton of an algorithm in the superclass but lets");
        System.out.println("subclasses override specific steps of the algorithm without changing its structure.\n");

        DataMiner pdfMiner = new PDFDataMiner();
        System.out.println("--- Starting PDF Mining ---");
        pdfMiner.mineData();
        
        DataMiner csvMiner = new CSVDataMiner();
        System.out.println("--- Starting CSV Mining ---");
        csvMiner.mineData();
    }
}
