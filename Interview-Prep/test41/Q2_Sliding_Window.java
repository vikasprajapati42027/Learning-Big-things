/**
 * INTERVIEWER: What is the Sliding Window pattern in DSA?
 * 
 * CANDIDATE: It's a technique for reducing the time complexity of problems 
 * involving arrays or strings by reusing the results of previous computations.
 * 
 * PROPER EXPLANATION:
 * 1. Fixed Window: Size is constant (e.g., Max sum of k elements).
 * 2. Variable Window: Size changes (e.g., Smallest sub-array with sum > S).
 * 3. Complexity: Usually reduces O(N^2) to O(N).
 */

public class Q2_Sliding_Window {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Max Sum (Window Size 4): " + findMaxSum(arr, k));
    }

    public static int findMaxSum(int[] arr, int k) {
        int max_sum = 0, current_sum = 0;
        for (int i = 0; i < k; i++) current_sum += arr[i];
        max_sum = current_sum;

        for (int i = k; i < arr.length; i++) {
            current_sum += arr[i] - arr[i - k]; // Slide!
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }
}
