package TestJava.Test70;

import java.util.Locale;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import java.text.DateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Locale and Internationalization (i18n) ===\n");

        // Locale represents a specific geographical, political, or cultural region.
        // It is used to format dates, numbers, and currencies according to local customs.

        Locale usLocale = Locale.US;
        Locale frenchLocale = Locale.FRANCE;
        Locale japaneseLocale = Locale.JAPAN;

        double amount = 1234567.89;
        Date today = new Date(); // Current date/time

        System.out.println("--- 1. Formatting Currency by Locale ---");
        System.out.println("US (USD)     : " + NumberFormat.getCurrencyInstance(usLocale).format(amount));
        System.out.println("France (EUR) : " + NumberFormat.getCurrencyInstance(frenchLocale).format(amount));
        System.out.println("Japan (JPY)  : " + NumberFormat.getCurrencyInstance(japaneseLocale).format(amount));

        System.out.println("\n--- 2. Formatting Dates by Locale ---");
        System.out.println("US Date     : " + DateFormat.getDateInstance(DateFormat.FULL, usLocale).format(today));
        System.out.println("French Date : " + DateFormat.getDateInstance(DateFormat.FULL, frenchLocale).format(today));
        System.out.println("Japan Date  : " + DateFormat.getDateInstance(DateFormat.FULL, japaneseLocale).format(today));
        
        // Note on ResourceBundles:
        // For real i18n applications, you create files like `messages_en_US.properties` and `messages_fr_FR.properties`,
        // and fetch strings like this: ResourceBundle bundle = ResourceBundle.getBundle("messages", frenchLocale);
        // This allows translating "Hello" into "Bonjour" automatically!
    }
}
