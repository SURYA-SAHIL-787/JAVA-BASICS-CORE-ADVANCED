// Base Class
class BankAccount {
    private String accountHolder;   // Encapsulation
    protected double balance;

    BankAccount(String name, double balance) {  // Constructor
        this.accountHolder = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void display() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    void calculateInterest() {   // Method to override
        System.out.println("No interest for basic account.");
    }
}

// Inheritance
class SavingsAccount extends BankAccount {

    SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    // Method Overriding (Polymorphism)
    @Override
    void calculateInterest() {
        double interest = balance * 0.05;
        System.out.println("Interest: " + interest);
    }
}

public class Main {
    public static void main(String[] args) {

        BankAccount acc = new SavingsAccount("Surya", 10000); // Polymorphism

        acc.deposit(2000);
        acc.display();
        acc.calculateInterest();
    }
}
