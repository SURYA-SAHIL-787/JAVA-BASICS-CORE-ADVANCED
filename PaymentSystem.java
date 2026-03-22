import java.util.Scanner;
interface Payment {
    void processPayment();
}
class CreditCard implements Payment {
    String cardNumber;
    double amount;
    CreditCard(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }
    public void processPayment() {
        System.out.println("Credit Card Payment Successful");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount Paid: " + amount);
    }
}
class UPI implements Payment {
    String upiId;
    double amount;
    UPI(String upiId, double amount) {
        this.upiId = upiId;
        this.amount = amount;
    }
    public void processPayment() {
        System.out.println("UPI Payment Successful");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount Paid: " + amount);
    }
}
public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment p;
        System.out.println("Choose Payment Mode:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter Card Number: ");
            String cardNumber = sc.nextLine();
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            p = new CreditCard(cardNumber, amount);
            p.processPayment();
        } 
        else if (choice == 2) {
            System.out.print("Enter UPI ID: ");
            String upiId = sc.nextLine();
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            p = new UPI(upiId, amount);
            p.processPayment();
        } 
        else {
            System.out.println("Invalid choice");
        }
        sc.close();
    }
}