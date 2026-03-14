package java_version.Java8_version.lambda.test2;

/**
 * Child class - extends Controller (parent).
 * Adds behavior and uses lambda to call View.
 */
public class ChildController extends Controller {

    public ChildController(Model model, View view) {
        super(model, view);
    }

    @Override
    public void refreshView() {
        // Lambda: supply a string that includes both message and extra info
        view.display(() -> "ChildController: " + model.getMessage() + " | count=" + model.getCount());
    }

    /** Child-specific: reset using lambda passed to View. */
    public void handleReset() {
        view.onButtonClick(() -> {
            model.setCount(0);
            model.setMessage("Reset by ChildController");
        });
    }
}
