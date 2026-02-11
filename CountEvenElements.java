import java.util.Scanner;

public class CountEvenElements {

    // CREATE A METHOD WHICH WILL GIVE THE COUNT OF EVEN ELEMENTS IN THE ARRAY
    static int countEvens(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {   
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int evenCount = countEvens(arr);
        System.out.println("Number of even elements = " + evenCount);

        sc.close();
    }
}
