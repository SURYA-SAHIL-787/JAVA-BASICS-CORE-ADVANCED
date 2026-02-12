import java.util.Scanner;

public class ReverseArrayUsingMethod {

    // CREATE A METHOD TO REVERSE THE ARRAY:
    static void reverseArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER ARRAY SIZE: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("ENTER " + n + " INTEGERS:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // REVERSE USING METHOD:
        reverseArray(arr); 

        System.out.println("REVERSED ARRAY:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
