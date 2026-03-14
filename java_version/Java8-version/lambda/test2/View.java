package java_version.Java8_version.lambda.test2;

import java.util.function.Supplier;

/**
 * View - displays data (MVC).
 * Uses lambda so Controller can pass what to show without View knowing Model.
 */
public class View {

    /** Show content supplied by a lambda (caller decides what to display). */
    public void display(Supplier<String> contentSupplier) {
        String content = contentSupplier.get();  // lambda call
        System.out.println("[View] " + content);
    }

    /** Run an action (lambda) when "button" is clicked. */
    public void onButtonClick(Runnable action) {
        System.out.print("[View] Button clicked -> ");
        action.run();  // lambda call
    }
}
