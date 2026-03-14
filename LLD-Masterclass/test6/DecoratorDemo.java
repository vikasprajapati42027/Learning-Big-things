public class DecoratorDemo {
    public static void main(String[] args) {
        // 1. Start with simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " -> ₹" + coffee.getCost());

        // 2. Add milk (Decorate)
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> ₹" + coffee.getCost());

        // 3. Add sugar (Decorate again)
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> ₹" + coffee.getCost());
        
        // Final result: Simple Coffee, Milk, Sugar -> ₹80.0
    }
}
