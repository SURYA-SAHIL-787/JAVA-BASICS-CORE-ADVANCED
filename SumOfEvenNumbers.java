import java.util.Scanner;

class SumOfEvenNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }

        System.out.println("Sum of even numbers from 1 to " + n + " is: " + sum);

        sc.close();
    }
}
