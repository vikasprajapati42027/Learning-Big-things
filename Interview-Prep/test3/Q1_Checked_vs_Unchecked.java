/**
 * INTERVIEWER: Explain the difference between Checked and Unchecked exceptions.
 * 
 * CANDIDATE: Checked exceptions are checked at compile-time, while Unchecked (Runtime) 
 * exceptions are not. This is a fundamental part of Java's robustness.
 * 
 * PROPER EXPLANATION:
 * 1. Checked Exceptions: Inherit from Exception (but not RuntimeException). The compiler 
 *    forces you to handle them (try-catch) or declare them (throws). Use these for 
 *    recoverable conditions (e.g., File missing).
 * 2. Unchecked Exceptions: Inherit from RuntimeException. Compiler doesn't force handling. 
 *    Typically result from programming logic errors (e.g., NullPointer).
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Q1_Checked_vs_Unchecked {
    public static void main(String[] args) {
        // 1. Handling a Checked Exception
        try {
            openFile("data.txt");
        } catch (IOException e) {
            System.out.println("Handled Checked Error: " + e.getMessage());
        }

        // 2. Handling an Unchecked Exception
        try {
            calculate(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Handled Unchecked Error: " + e.getMessage());
        }
    }

    // Checked: Compiler REQUIRES 'throws' or 'try-catch'
    public static void openFile(String path) throws IOException {
        File f = new File(path);
        FileReader fr = new FileReader(f);
    }

    // Unchecked: Compiler does NOT require 'throws'
    public static int calculate(int a, int b) {
        return a / b;
    }
}
