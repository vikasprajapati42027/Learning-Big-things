package Test_java_leanring.test93;

/** test93 - Builder pattern */
public class Builder {
    private String a, b;
    Builder setA(String a) { this.a = a; return this; }
    Builder setB(String b) { this.b = b; return this; }
    String build() { return a + "-" + b; }
}
