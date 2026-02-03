import java.util.Scanner;

class DiscountCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bill amount: ");
        int amount = sc.nextInt();

        if (amount > 1000) {
            System.out.println("Discount is applicable");
        } else {
            System.out.println("Discount is not applicable");
        }

        sc.close();
    }
}

