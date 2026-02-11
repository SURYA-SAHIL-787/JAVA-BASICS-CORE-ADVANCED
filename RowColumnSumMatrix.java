import java.util.Scanner;

public class RowColumnSumMatrix {

    // CREATE A METHOD TO PRINT ROW-WISE SUMS
    static void rowWiseSum(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int sum = 0;
            for (int j = 0; j < m[0].length; j++) {
                sum += m[i][j];
            }
            System.out.println("Sum of Row " + (i + 1) + " = " + sum);
        }
    }

    // CREATE A METHOD TO PRINT COLUMN-WISE SUMS
    static void columnWiseSum(int[][] m) {
        for (int j = 0; j < m[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < m.length; i++) {
                sum += m[i][j];
            }
            System.out.println("Sum of Column " + (j + 1) + " = " + sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nRow-wise sums:");
        rowWiseSum(matrix);

        System.out.println("\nColumn-wise sums:");
        columnWiseSum(matrix);

        sc.close();
    }
}
