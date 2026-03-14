public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory;
        String os = "MAC"; // This can come from config file

        if (os.equalsIgnoreCase("WINDOWS")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // The app doesn't care if it's Windows or Mac!
        Button btn = factory.createButton();
        Checkbox chk = factory.createCheckbox();

        btn.paint();
        chk.paint();
    }
}
