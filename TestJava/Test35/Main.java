package TestJava.Test35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Comparable (Natural Ordering inside the class)
// Implemented BY the class itself. Defines the "default" way to sort these objects.
class Student implements Comparable<Student> {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Must override compareTo
    @Override
    public int compareTo(Student otherStudent) {
        // Default sorting by Roll Number
        return Integer.compare(this.rollNo, otherStudent.rollNo);
    }

    @Override
    public String toString() { return rollNo + "-" + name; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Comparable vs Comparator ===");

        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Charlie"));
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));

        System.out.println("Original List: " + students);

        // --- 1. Using Comparable ---
        // automatically uses the compareTo() method defined inside the Student class!
        Collections.sort(students); 
        System.out.println("\nSorted Naturally (by RollNo using Comparable): " + students);

        // --- 2. Using Comparator ---
        // Extracted outside the class. Used to define CUSTOM sorting logic without modifying the original class.
        // Let's sort by Name instead!
        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name); // Alphabetical sort
            }
        };

        // Or cleanly using Lambdas:
        // Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);

        Collections.sort(students, nameComparator);
        System.out.println("\nSorted Customly (by Name using Comparator): " + students);
    }
}
