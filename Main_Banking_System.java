import java.util.Scanner;
class Account {
    int accNo;
    String name;
    double balance;
    void getAccountDetails(Scanner sc) {
        System.out.print("ENTER ACCOUNT NUMBER: ");
        accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("ENTER ACCOUNT HOLDER NAME: ");
        name = sc.nextLine();
        System.out.print("ENTER BALANCE: ");
        balance = sc.nextDouble();
        sc.nextLine();
    }
    void displayAccountDetails() {
        System.out.println("ACCOUNT NUMBER : " + accNo);
        System.out.println("NAME           : " + name);
        System.out.println("BALANCE        : " + balance);
    }
}
class SavingsAccount extends Account {
    double interestRate;
    void getSavingsDetails(Scanner sc) {
        getAccountDetails(sc);
        System.out.print("ENTER INTEREST RATE (%): ");
        interestRate = sc.nextDouble();
        sc.nextLine();
    }
    void displaySavingsDetails() {
        displayAccountDetails();
        System.out.println("INTEREST RATE  : " + interestRate + "%");
    }
}
class CurrentAccount extends Account {
    double overdraftLimit;
    void getCurrentDetails(Scanner sc) {
        getAccountDetails(sc);
        System.out.print("ENTER OVERDRAFT LIMIT: ");
        overdraftLimit = sc.nextDouble();
        sc.nextLine();
    }
    void displayCurrentDetails() {
        displayAccountDetails();
        System.out.println("OVERDRAFT LIMIT: " + overdraftLimit);
    }
}
public class Main_Banking_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. SAVINGS ACCOUNT");
        System.out.println("2. CURRENT ACCOUNT");
        System.out.print("CHOOSE TYPE: ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println();
        if (choice == 1) {
            SavingsAccount s = new SavingsAccount();
            s.getSavingsDetails(sc);
            System.out.println("\n--- SAVINGS ACCOUNT DETAILS ---");
            s.displaySavingsDetails();
        } else if (choice == 2) {
            CurrentAccount c = new CurrentAccount();
            c.getCurrentDetails(sc);
            System.out.println("\n--- CURRENT ACCOUNT DETAILS ---");
            c.displayCurrentDetails();
        } else {
            System.out.println("INVALID CHOICE.");
        }
        sc.close();
    }
}
