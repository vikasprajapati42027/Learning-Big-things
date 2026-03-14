package java_version.Java8_version.lambda.test2;

/**
 * test2 - Model, View, Controller + Parent/Child + Lambda.
 *
 * Flow:
 * - Model = data
 * - View = display, takes lambda (Supplier / Runnable)
 * - Controller (parent) = wires Model + View with lambda
 * - ChildController (child) = extends Controller, uses lambda for View calls
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== test2: MVC + Parent/Child + Lambda ===\n");

        Model model = new Model();
        View view = new View();
        model.setMessage("Hello");

        // ---- Parent: Controller ----
        Controller parent = new Controller(model, view);
        parent.refreshView();   // lambda inside: () -> model.getMessage() + ...
        parent.handleClick();   // lambda inside: () -> { model.incrementCount(); ... }
        parent.refreshView();

        System.out.println();

        // ---- Child: ChildController ----
        Model model2 = new Model();
        model2.setMessage("Child data");
        View view2 = new View();
        ChildController child = new ChildController(model2, view2);

        child.refreshView();    // lambda in child
        child.handleClick();   // lambda from parent
        child.refreshView();
        child.handleReset();   // child-specific lambda
        child.refreshView();
    }
}
