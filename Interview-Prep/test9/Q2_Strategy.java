/**
 * INTERVIEWER: What is the Strategy Pattern?
 * CANDIDATE: It defines a family of algorithms and makes them interchangeable at runtime.
 */
interface SortingStrategy { void sort(int[] arr); }
class BubbleSort implements SortingStrategy { public void sort(int[] a) { System.out.println("Sorting using Bubble Sort"); } }
class QuickSort implements SortingStrategy { public void sort(int[] a) { System.out.println("Sorting using Quick Sort"); } }
class Sorter {
    private SortingStrategy strategy;
    public void setStrategy(SortingStrategy s) { this.strategy = s; }
    public void performSort(int[] a) { strategy.sort(a); }
}
public class Q2_Strategy {
    public static void main(String[] args) {
        Sorter context = new Sorter();
        context.setStrategy(new QuickSort());
        context.performSort(new int[]{1, 2, 3});
    }
}
