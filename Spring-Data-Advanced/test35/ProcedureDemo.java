class CallParent { String name = "PROC_NAME"; }
class TaxProcedure extends CallParent { }
public class ProcedureDemo {
    public static void main(String[] args) { System.out.println("Call: " + new TaxProcedure().name); }
}
