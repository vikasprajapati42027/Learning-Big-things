public class TemplateDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play(); // Calls the template method
        
        System.out.println();
        
        game = new Football();
        game.play();
    }
}
