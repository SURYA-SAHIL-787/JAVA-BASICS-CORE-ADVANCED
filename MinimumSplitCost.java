public class MinimumSplitCost {

    public static int minSplitCost(int[] arr, int k) {
        int n = arr.length;
        int[][] cost = new int[n][n];

        // Precompute cost of every subarray
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int max = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                cost[i][j] = max - min;
            }
        }

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int p = 0; p <= k; p++) {
                dp[i][p] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][1] = cost[0][i];
        }

        for (int p = 2; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j][p - 1] != Integer.MAX_VALUE) {
                        dp[i][p] = Math.min(dp[i][p], dp[j][p - 1] + cost[j + 1][i]);
                    }
                }
            }
        }

        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 8, 3};
        int k = 3;

        System.out.println("Minimum Split Cost: " + minSplitCost(arr, k));
    }
}
