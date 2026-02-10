import java.util.Scanner;

public class SymmetricMatrixCheck {

    // CREATE A METHOD TO CHECK THE SYMMETRY OF A MATRIX
    static boolean isSymmetric(int[][] m) {
        // SQUARE MATRIX CHECK
        if (m.length != m[0].length) return false;

        int n = m.length;
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] != m[j][i]) {  
                    return false;
                }
            }
        }
        return true;
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

        boolean symmetric = isSymmetric(matrix);

        if (symmetric) {
            System.out.println("Matrix is Symmetric.");
        } else {
            System.out.println("Matrix is NOT Symmetric.");
        }

        sc.close();
    }
}
