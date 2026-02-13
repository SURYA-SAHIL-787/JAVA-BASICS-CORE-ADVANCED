import java.util.Scanner;
class BankAccount {
    String accountNumber;
    double balance;
    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0; 
    }
    BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
    }
}
public class Main_Banking_Explanation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Create account with ONLY Account Number");
        System.out.println("2) Create account with Account Number + Initial Balance");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        if (choice == 1) {
            System.out.print("Enter account number: ");
            String accNo = sc.nextLine();
            BankAccount a1 = new BankAccount(accNo); 
            a1.display();
        } else if (choice == 2) {
            System.out.print("Enter account number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter initial balance: ");
            double bal = sc.nextDouble();
            BankAccount a2 = new BankAccount(accNo, bal); 
            a2.display();
        } else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
