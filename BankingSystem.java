import java.util.Scanner;
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}
public class BankingSystem {
    static void withdraw(int balance, int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter balance:");
        int balance = sc.nextInt();
        System.out.println("Enter withdrawal amount:");
        int amount = sc.nextInt();
        try {
            withdraw(balance, amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}


