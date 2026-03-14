package Test_java_leanring.test11;

/** test11 - equals() and hashCode() */
public class Box {
    private int id;
    public Box(int id) { this.id = id; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id == ((Box) o).id;
    }
    @Override
    public int hashCode() { return Integer.hashCode(id); }
}
