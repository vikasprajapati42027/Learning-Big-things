public class CompositeDemo {
    public static void main(String[] args) {
        // Individual files (Leaf nodes)
        File f1 = new File("resume.pdf");
        File f2 = new File("photo.jpg");
        File f3 = new File("config.sys");

        // A folder (Composite node)
        Folder myDocs = new Folder("MyDocuments");
        myDocs.addComponent(f1);
        myDocs.addComponent(f2);

        // A bigger folder containing the previous folder
        Folder root = new Folder("C_Drive");
        root.addComponent(f3);
        root.addComponent(myDocs);

        // Treat the whole structure as one object!
        root.showDetails();
    }
}
