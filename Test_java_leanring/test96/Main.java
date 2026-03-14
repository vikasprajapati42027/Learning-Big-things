package Test_java_leanring.test96;

import java.util.EnumSet;
import java.util.Set;

/** test96 - EnumSet */
enum Flag { A, B, C }

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test96: EnumSet ===");
        Set<Flag> set = EnumSet.of(Flag.A, Flag.C);
        System.out.println(set);
    }
}
