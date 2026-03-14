package Test_java_leanring.test84;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** test84 - Pattern Matcher (regex) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test84: Regex ===");
        Matcher m = Pattern.compile("\\d+").matcher("a12b34");
        if (m.find()) System.out.println(m.group());
    }
}
