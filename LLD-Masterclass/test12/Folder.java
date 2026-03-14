import java.util.ArrayList;
import java.util.List;

public class Folder implements FileComponent {
    private String name;
    private List<FileComponent> components = new ArrayList<>();

    public Folder(String name) { this.name = name; }

    public void addComponent(FileComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: [" + name + "]");
        for (FileComponent child : components) {
            child.showDetails();
        }
    }
}
