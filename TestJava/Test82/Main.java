package TestJava.Test82;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== EnumSet & EnumMap Tutorial ===\n");

        // EnumSet and EnumMap are highly optimized, extremely fast, memory-efficient 
        // collections specifically tailored for Java Enums.
        // Internally, they represent presence/absence using a single BIT VECTOR (long)!

        System.out.println("--- 1. EnumSet ---");
        
        // All days
        Set<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);
        
        // Empty set to start
        Set<Day> weekend = EnumSet.noneOf(Day.class);
        weekend.add(Day.SATURDAY);
        weekend.add(Day.SUNDAY);
        System.out.println("Weekend: " + weekend);
        
        // Range
        Set<Day> workDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Work Days: " + workDays);

        System.out.println("\n--- 2. EnumMap ---");
        
        // EnumMap enforces that all Keys MUST come from a specific Enum class.
        // It uses an underlying Array, making it faster than a HashMap!
        Map<Day, String> schedule = new EnumMap<>(Day.class);
        
        schedule.put(Day.MONDAY, "Team Meeting");
        schedule.put(Day.WEDNESDAY, "Code Review");
        schedule.put(Day.FRIDAY, "Release Deployment");
        
        for (Map.Entry<Day, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
