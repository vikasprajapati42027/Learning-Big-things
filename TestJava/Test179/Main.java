package TestJava.Test179;

// 1. The Abstract Expression
interface Expression {
    boolean interpret(String context);
}

// 2. Terminal Expression (The smallest unit of grammar)
class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) { this.data = data; }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

// 3. Non-Terminal Expressions (Combines multiple expressions)
class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) { 
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) { 
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 179: Interpreter Pattern ===\n");

        System.out.println("Defines a grammatical representation for a language and provides an");
        System.out.println("interpreter to deal with this grammar. (Used in SQL Parsers, Regex engines!)\n");

        // Rule: Robert and John are males
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        Expression isMale = new OrExpression(robert, john);

        // Rule: Julie is a married woman
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        Expression isMarriedWoman = new AndExpression(julie, married);

        System.out.println("Is John male? " + isMale.interpret("John"));
        System.out.println("Is Robert male? " + isMale.interpret("Robert"));
        System.out.println("Is Julie a married woman? " + isMarriedWoman.interpret("Married Julie"));
        System.out.println("Is Alice a married woman? " + isMarriedWoman.interpret("Married Alice"));
    }
}
