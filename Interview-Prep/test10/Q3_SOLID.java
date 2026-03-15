/**
 * INTERVIEWER: SOLID Principle Scenario 3.
 * CANDIDATE: Professional implementation of SOLID principle 3.
 */
import java.util.*;
abstract class Bird {
    abstract void eat();
    abstract String name();
}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    public void eat() {
        System.out.println("Sparrow pecks seeds.");
    }

    public String name() {
        return "Sparrow";
    }

    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}

class Penguin extends Bird {
    public void eat() {
        System.out.println("Penguin catches fish.");
    }

    public String name() {
        return "Penguin";
    }
}

public class Q3_SOLID {
    public static void main(String[] args) {
        List<Bird> birds = Arrays.asList(new Sparrow(), new Penguin());
        birds.forEach(bird -> {
            System.out.println(bird.name() + " is eating:");
            bird.eat();
            if (bird instanceof Flyable) {
                ((Flyable) bird).fly();
            }
        });
    }
}
