package TestJava.Test142;

// We use a Record here because it's the perfect immutable data carrier!
record UserProfile(String username, String email, int age, boolean isPremium, String avatarUrl) {

    // 1. The inner static Builder class
    public static class Builder {
        // Required parameters
        private final String username;
        private final String email;
        
        // Optional parameters - initialized to default values
        private int age = 0;
        private boolean isPremium = false;
        private String avatarUrl = "default.png";

        // Constructor for required parameters
        public Builder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        // Setter methods that return the Builder itself for method chaining!
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder premium(boolean isPremium) {
            this.isPremium = isPremium;
            return this;
        }

        public Builder avatar(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        // The final build method constructs the target object
        public UserProfile build() {
            return new UserProfile(username, email, age, isPremium, avatarUrl);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Pattern: Builder (with Records) ===\n");

        System.out.println("The Builder pattern handles complex object creation step-by-step.");
        System.out.println("It solves the 'Telescoping Constructor' anti-pattern (where you have a dozen confusing constructors).\n");

        // 1. Creating a basic user (only relying on required fields)
        UserProfile basicUser = new UserProfile.Builder("john_doe", "john@example.com").build();
        System.out.println("Basic User: " + basicUser);

        // 2. Creating a complex user (chaining optional parameters fluidly!)
        UserProfile powerUser = new UserProfile.Builder("vikas", "vikas@admin.com")
                .age(28)
                .premium(true)
                .avatar("https://cdn.example.com/vikas.jpg")
                .build();
                
        System.out.println("\nPremium User: " + powerUser);
    }
}
