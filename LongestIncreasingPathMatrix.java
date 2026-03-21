public class LongestIncreasingPathMatrix {

    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxLength = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxLength = Math.max(maxLength, dfs(matrix, r, c, memo));
            }
        }

        return maxLength;
    }

    private static int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int max = 1;

        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                    && matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(matrix, nr, nc, memo));
            }
        }

        memo[r][c] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };

        System.out.println(longestIncreasingPath(matrix));
    }
}
