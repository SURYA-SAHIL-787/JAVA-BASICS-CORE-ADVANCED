import java.util.ArrayList;
import java.util.List;

public class PeakBalanceIndex {

    public static List<Integer> findPeakBalanceIndices(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            boolean leftOk = (i == 0) || (arr[i] >= prefixMax[i - 1]);
            boolean rightOk = (i == n - 1) || (arr[i] <= suffixMin[i + 1]);

            if (leftOk && rightOk) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> indices = findPeakBalanceIndices(arr);

        System.out.println("Peak Balance Indices: " + indices);
    }
}
