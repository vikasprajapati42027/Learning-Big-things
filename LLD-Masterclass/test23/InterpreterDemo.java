public class InterpreterDemo {
    // Rule: Robert OR John is male
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();

        System.out.println("Is John male? " + isMale.interpret("John"));
        System.out.println("Is Julie male? " + isMale.interpret("Julie"));
    }
}
