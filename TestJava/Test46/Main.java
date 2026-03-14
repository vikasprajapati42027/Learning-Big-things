package TestJava.Test46;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// The Fork/Join framework is designed for work that can be broken down recursively into smaller pieces.
// It uses a "work-stealing" algorithm where idle threads steal tasks from busy threads!
class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000; // Tasks smaller than 1000 items are calculated directly
    private long[] array;
    private int start;
    private int end;

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // If the task is small enough, calculate it directly (Base Case)
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Otherwise, "FORK" it into two smaller sub-tasks
            int middle = start + (end - start) / 2;
            SumTask leftTask = new SumTask(array, start, middle);
            SumTask rightTask = new SumTask(array, middle, end);

            // Start the left task in a separate thread
            leftTask.fork();

            // Compute right task in the current thread
            Long rightResult = rightTask.compute();

            // "JOIN" the left result
            Long leftResult = leftTask.join();

            // Combine
            return leftResult + rightResult;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Fork/Join Framework Tutorial ===");

        // Create a massive array
        int size = 10_000_000;
        long[] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1; // 1 to 10M
        }

        // Create the common thread pool
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // Start the root task
        System.out.println("Starting computation for " + size + " numbers...");
        long startTime = System.currentTimeMillis();
        
        SumTask rootTask = new SumTask(numbers, 0, numbers.length);
        long totalSum = pool.invoke(rootTask);
        
        long endTime = System.currentTimeMillis();

        System.out.println("Total Sum: " + totalSum);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
