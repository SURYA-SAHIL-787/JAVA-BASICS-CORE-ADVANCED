import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accNo, String name, double bal) {
        accountNumber = accNo;
        holderName = name;
        balance = bal;
    }

    // Getters
    String getAccountNumber() { return accountNumber; }
    String getHolderName() { return holderName; }
    double getBalance() { return balance; }

    void deposit(double amt) {
        if (amt <= 0) {
            System.out.println("Deposit must be positive!");
            return;
        }
        balance += amt;
        System.out.println("Deposit successful!");
    }

    void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Withdraw must be positive!");
            return;
        }
        if (amt > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amt;
        System.out.println("Withdraw successful!");
    }

    void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account No : " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance    : " + balance);
    }
}

public class MainBankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount acc = new BankAccount(accNo, name, bal);

        int choice;
        do {
            System.out.println("\n1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Display Account");
            System.out.println("5) Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double amt = sc.nextDouble();
                acc.deposit(amt);
            } else if (choice == 2) {
                System.out.print("Enter withdraw amount: ");
                double amt = sc.nextDouble();
                acc.withdraw(amt);
            } else if (choice == 3) {
                System.out.println("Current Balance: " + acc.getBalance());
            } else if (choice == 4) {
                acc.displayAccount();
            } else if (choice == 5) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        System.out.println("\nFinal Summary:");
        acc.displayAccount();

        sc.close();
    }
}
