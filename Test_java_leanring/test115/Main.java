package Test_java_leanring.test115;

import java.math.BigDecimal;

/** test115 - BigDecimal */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test115: BigDecimal ===");
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(a.add(b));
    }
}
