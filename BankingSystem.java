import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    // Abstract parent class
    static abstract class BankAccount {
        private String accountHolder;
        protected double balance;
        protected List<String> transactions = new ArrayList<>();

        public BankAccount(String accountHolder, double balance) {
            this.accountHolder = accountHolder;
            this.balance = balance;
            transactions.add("Account opened with balance: " + balance);
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactions.add("Deposited: " + amount);
            }
        }

        public abstract void withdraw(double amount);
        public abstract double calculateInterest();

        public void printDetails() {
            System.out.println("\nAccount Holder: " + accountHolder);
            System.out.println("Balance: " + balance);
            System.out.println("Interest: " + calculateInterest());
            System.out.println("Transactions:");
            for (String t : transactions) {
                System.out.println(" - " + t);
            }
        }
    }

    static class SavingsAccount extends BankAccount {
        private final double interestRate = 0.05;
        private final double minimumBalance = 500;

        public SavingsAccount(String name, double balance) {
            super(name, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (balance - amount >= minimumBalance) {
                balance -= amount;
                transactions.add("Withdrawn: " + amount);
            } else {
                transactions.add("Withdrawal failed: Minimum balance rule");
                System.out.println("Cannot withdraw. Minimum balance must be maintained.");
            }
        }

        @Override
        public double calculateInterest() {
            return balance * interestRate;
        }
    }

    static class CurrentAccount extends BankAccount {
        private final double overdraftLimit = 2000;

        public CurrentAccount(String name, double balance) {
            super(name, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (balance + overdraftLimit >= amount) {
                balance -= amount;
                transactions.add("Withdrawn: " + amount);
            } else {
                transactions.add("Withdrawal failed: Overdraft exceeded");
                System.out.println("Cannot withdraw. Overdraft limit exceeded.");
            }
        }

        @Override
        public double calculateInterest() {
            return 0;
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new SavingsAccount("Sahil", 5000);
        BankAccount a2 = new CurrentAccount("Ravi", 1000);

        a1.deposit(2000);
        a1.withdraw(6200);

        a2.deposit(500);
        a2.withdraw(3000);

        a1.printDetails();
        a2.printDetails();
    }
}
