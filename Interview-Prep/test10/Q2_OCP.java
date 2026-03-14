/**
 * INTERVIEWER: Open-Closed Principle?
 * CANDIDATE: Entities should be open for extension but closed for modification.
 */
interface Shape { double area(); }
class Circle implements Shape { public double area() { return 1.0; } }
class Square implements Shape { public double area() { return 1.0; } }
public class Q2_OCP { }
