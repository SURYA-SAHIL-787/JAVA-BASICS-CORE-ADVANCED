import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NearestGreaterFrequency {

    public static int[] findNGFE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Map<Integer, Integer> freqMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Count frequency of each element
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   freqMap.get(arr[stack.peek()]) <= freqMap.get(arr[i])) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] result = findNGFE(arr);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
