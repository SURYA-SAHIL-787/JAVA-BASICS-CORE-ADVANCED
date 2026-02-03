import java.util.Scanner;

class PalindromeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        if (original == reverse) {
            System.out.println("Palindrome number");
        } else {
            System.out.println("Not a palindrome number");
        }

        sc.close();
    }
}
