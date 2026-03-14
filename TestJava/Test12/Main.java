package TestJava.Test12;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Modern Date & Time API (java.time) ===");
        
        // 1. LocalDate (Just the date: Year, Month, Day)
        LocalDate today = LocalDate.now();
        System.out.println("\nToday's Date: " + today);
        
        LocalDate moonLanding = LocalDate.of(1969, 7, 20);
        System.out.println("Moon Landing: " + moonLanding);
        
        // 2. LocalTime (Just the time: Hours, Minutes, Seconds, Nanoseconds)
        LocalTime now = LocalTime.now();
        System.out.println("\nCurrent Time: " + now);
        
        // 3. LocalDateTime (Date AND Time)
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("\nCurrent Date and Time: " + currentDateTime);
        
        // 4. Formatting Dates
        // The default format is ISO-8601 (YYYY-MM-DD), but we can change it:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("\nFormatted Date and Time: " + formattedDateTime);
        
        // 5. Calculating Time Differences (Period)
        Period timeSinceMoonLanding = Period.between(moonLanding, today);
        System.out.println("\nTime since Moon Landing: " + 
            timeSinceMoonLanding.getYears() + " years, " + 
            timeSinceMoonLanding.getMonths() + " months, and " + 
            timeSinceMoonLanding.getDays() + " days.");
            
        System.out.println("\nDate and Time API demonstrated successfully!");
    }
}
