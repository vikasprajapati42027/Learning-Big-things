public class File implements FileComponent {
    private String name;
    public File(String name) { this.name = name; }
    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}
