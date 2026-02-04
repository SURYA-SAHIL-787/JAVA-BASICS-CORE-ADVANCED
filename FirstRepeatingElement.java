import java.util.Scanner;

class FirstRepeatingElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int firstRepeat = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    firstRepeat = arr[i];
                    break;
                }
            }
            if (firstRepeat != -1)
                break;
        }

        if (firstRepeat != -1)
            System.out.println("First repeating element = " + firstRepeat);
        else
            System.out.println("No repeating elements");

        sc.close();
    }
}
