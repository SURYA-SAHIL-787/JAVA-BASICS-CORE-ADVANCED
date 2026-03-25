import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class OnlineTransactionSystem {

    static void processTransaction(int balance, int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        int result = balance - amount;
        System.out.println("Transaction successful");
        System.out.println("Remaining balance: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter balance:");
        try {
            int balance = sc.nextInt();

            System.out.println("Enter transaction amount:");
            int amount = sc.nextInt();

            processTransaction(balance, amount);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error occurred");
        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            System.out.println("Transaction process completed");
            sc.close();
        }
    }
}
