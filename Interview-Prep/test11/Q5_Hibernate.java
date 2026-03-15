/**
 * INTERVIEWER: Hibernate Topic 5.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
public class Q5_Hibernate {
    static class Vehicle {
        private final String registration;

        Vehicle(String registration) {
            this.registration = registration;
        }

        @Override
        public String toString() {
            return "Vehicle{" + registration + "}";
        }
    }

    static class Car extends Vehicle {
        Car(String registration) {
            super(registration);
        }
    }

    static class Motorcycle extends Vehicle {
        Motorcycle(String registration) {
            super(registration);
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Car("HIB-100");
        Vehicle bike = new Motorcycle("HIB-101");
        System.out.println("Discriminator table would include: " + car + " and " + bike);
    }
}
