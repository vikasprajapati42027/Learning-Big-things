public class MediatorDemo {
    public static void main(String[] args) {
        User vikas = new User("Vikas");
        User amit = new User("Amit");

        vikas.sendMessage("Hi Amit!");
        amit.sendMessage("Hello Vikas, how are you?");
    }
}
