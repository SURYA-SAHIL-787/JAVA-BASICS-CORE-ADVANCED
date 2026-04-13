import java.util.HashMap;
import java.util.Map;

public class CircularDominantSubarray {

    public static int longestDominantSubarray(int[] arr) {
        int n = arr.length;
        int[] circular = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            circular[i] = arr[i % n];
        }

        int maxLength = 0;

        for (int start = 0; start < n; start++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            int maxFreq = 0;

            for (int end = start; end < start + n; end++) {
                int value = circular[end];
                freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
                maxFreq = Math.max(maxFreq, freqMap.get(value));

                int length = end - start + 1;
                if (maxFreq > length / 2) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2};
        System.out.println("Longest Circular Dominant Subarray Length: " +
                longestDominantSubarray(arr));
    }
}
