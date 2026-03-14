package TestJava.Test57;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Number Formatting Tutorial ===\n");

        double rawNumber = 1234567.8945;
        System.out.println("Raw Number: " + rawNumber);

        // --- 1. NumberFormat (Locale Specific) ---
        // Java provides built-in formats based on a specific Country/Region.
        System.out.println("\n--- 1. NumberFormat (Local Settings) ---");
        
        // General number format for US (adds commas)
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        System.out.println("US Format (General): " + usFormat.format(rawNumber)); // 1,234,567.894
        
        // General number format for Germany (dots for thousands, comma for decimal)
        NumberFormat deFormat = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println("German Format (General): " + deFormat.format(rawNumber)); // 1.234.567,894

        // Currency format for US
        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US Currency: " + usCurrency.format(rawNumber)); // $1,234,567.89

        // --- 2. DecimalFormat (Custom Patterns) ---
        // You define a specific string pattern to format the number exactly how you want.
        System.out.println("\n--- 2. DecimalFormat (Custom Patterns) ---");
        
        // 0 = Required digit (pads with zeros if missing)
        // # = Optional digit (no padding)
        
        // Example: Only keep exactly 2 decimal places. 
        DecimalFormat pattern1 = new DecimalFormat("#,###.00");
        System.out.println("Custom Pattern [#,###.00]: " + pattern1.format(rawNumber)); // 1,234,567.89

        // Example: Pad integer part to 10 digits with leading zeros
        DecimalFormat pattern2 = new DecimalFormat("0000000000.##");
        System.out.println("Custom Pattern [0000000000.##]: " + pattern2.format(rawNumber)); // 0001234567.89

        // Example: Format as a percentage (multiplies by 100 and adds %)
        double conversionRate = 0.045;
        DecimalFormat percentPattern = new DecimalFormat("#.##%");
        System.out.println("Custom Percentage [#.##%]: " + percentPattern.format(conversionRate)); // 4.5%
    }
}
