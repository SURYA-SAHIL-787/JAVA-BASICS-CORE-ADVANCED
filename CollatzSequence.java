import java.util.Scanner;

class CollatzSequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Collatz Sequence is not defined for 0 and negative numbers.");
            System.out.println("It exists only for positive integers.");
        } else {
            System.out.print("Collatz sequence: ");

            while (n != 1) {
                System.out.print(n + " ");

                if (n % 2 == 0)
                    n = n / 2;
                else
                    n = 3 * n + 1;
            }

            System.out.print("1");
        }

        sc.close();
    }
}
