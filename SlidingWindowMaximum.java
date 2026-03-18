import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>(); // stores indices
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove indices out of current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Start recording result when first window is complete
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
