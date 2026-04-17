import java.util.*;

public class FloydWarshall {
    static void shortestDistance(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = (int)1e9;
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)1e9) matrix[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 3, -1, 7},
            {-1, 0, 1, -1},
            {-1, -1, 0, 2},
            {-1, -1, -1, 0}
        };

        shortestDistance(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
