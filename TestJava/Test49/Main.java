package TestJava.Test49;

import java.util.Optional;

class Address {
    private String city;
    public Address(String city) { this.city = city; }
    public String getCity() { return city; }
}

class User {
    private String name;
    private Optional<Address> address; // User MIGHT NOT have an address

    public User(String name, Address address) {
        this.name = name;
        this.address = Optional.ofNullable(address);
    }

    public String getName() { return name; }
    public Optional<Address> getAddress() { return address; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Advanced Optionals Tutorial ===");

        User userWithAddress = new User("Alice", new Address("Wonderland"));
        User userWithoutAddress = new User("Bob", null);

        // --- 1. map() ---
        // Used to transform the value inside the Optional IF it exists.
        // It automatically wraps the return value in a NEW Optional.
        System.out.println("\n--- 1. Using map() ---");
        
        // We get an Optional<Address>, map it to Optional<String> (the city)
        String city1 = userWithAddress.getAddress()
                .map(Address::getCity) 
                .orElse("Unknown City");
        System.out.println("Alice's City: " + city1);

        String city2 = userWithoutAddress.getAddress()
                .map(Address::getCity)
                .orElse("Unknown City");
        System.out.println("Bob's City: " + city2);

        // --- 2. flatMap() ---
        // Used when the mapping function ALREADY RETURNS an Optional.
        // It prevents you from getting an Optional<Optional<T>>.
        System.out.println("\n--- 2. Using flatMap() ---");
        
        Optional<User> optionalUser = Optional.of(userWithAddress);
        
        // WRONG: optionalUser.map(User::getAddress) -> Returns Optional<Optional<Address>>
        // CORRECT: optionalUser.flatMap(User::getAddress) -> Returns Optional<Address>
        
        String flatMappedCity = optionalUser
                .flatMap(User::getAddress)
                .map(Address::getCity)
                .orElse("No City Found");
                
        System.out.println("FlatMapped City: " + flatMappedCity);

        // --- 3. filter() ---
        // Keeps the value if it matches the condition, otherwise returns an empty Optional.
        System.out.println("\n--- 3. Using filter() ---");
        
        Optional<String> specificCity = userWithAddress.getAddress()
                .map(Address::getCity)
                .filter(city -> city.startsWith("W")); // Only keep cities starting with 'W'
                
        specificCity.ifPresent(c -> System.out.println("Found a specific city: " + c));
    }
}
