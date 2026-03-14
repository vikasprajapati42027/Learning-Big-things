package java_version.Java8_version.lambda.test2;

/**
 * Parent (Controller) - base class.
 * Holds Model and View, connects them using lambda calls.
 */
public class Controller {
    protected final Model model;
    protected final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /** Update view by passing a lambda that reads from model. */
    public void refreshView() {
        view.display(() -> model.getMessage() + " (count=" + model.getCount() + ")");
    }

    /** Handle user action via lambda. */
    public void handleClick() {
        view.onButtonClick(() -> {
            model.incrementCount();
            model.setMessage("Clicked!");
        });
    }
}
