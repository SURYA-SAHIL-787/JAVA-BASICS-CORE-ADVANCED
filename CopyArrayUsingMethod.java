import java.util.Scanner;

public class CopyArrayUsingMethod {

    // CREATE METHOD TO COPY ARRAY:
    static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] original = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }

        int[] copied = copyArray(original);

        System.out.println("Copied array elements:");
        for (int i = 0; i < copied.length; i++) {
            System.out.print(copied[i] + " ");
        }

        sc.close();
    }
}
