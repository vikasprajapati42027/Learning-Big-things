/**
 * INTERVIEWER: What is the difference between '==' and '.equals()'?
 * 
 * CANDIDATE: '==' compares memory addresses (reference equality). 
 * '.equals()' compares the values (if overridden).
 *
 * PROPER EXPLANATION:
 * 1. Reference Equality (==): Checks if two variables point to the same object in Heap.
 * 2. Content Equality (.equals()): Defined in Object class (initially same as ==). 
 *    Classes like String, Integer override it to compare contents.
 * 3. Contract: If you override equals(), you MUST override hashCode() to maintain HashMap consistency.
 */

public class Q6_Equals {
    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = new String("Java");
        String s3 = s1;

        System.out.println("Comparison using == (Reference):");
        System.out.println("s1 == s2: " + (s1 == s2)); // false
        System.out.println("s1 == s3: " + (s1 == s3)); // true

        System.out.println("\nComparison using .equals() (Content):");
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        
        // Custom object check
        Person p1 = new Person(1, "Vikas");
        Person p2 = new Person(1, "Vikas");
        System.out.println("\nCustom Object Case:");
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true (because overridden)
    }
}

class Person {
    int id; String name;
    Person(int i, String n) { id = i; name = n; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }
}
