public class VisitorDemo {
    public static void main(String[] args) {
        ComputerPart monitor = new Monitor();
        ComputerPart keyboard = new Keyboard();

        ComputerPartVisitor displayVisitor = new ComputerPartDisplayVisitor();

        monitor.accept(displayVisitor);
        keyboard.accept(displayVisitor);
    }
}
