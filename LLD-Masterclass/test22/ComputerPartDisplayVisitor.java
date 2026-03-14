public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) { System.out.println("Displaying Keyboard."); }
    @Override
    public void visit(Monitor monitor) { System.out.println("Displaying Monitor."); }
}
