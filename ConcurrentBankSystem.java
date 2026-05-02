import java.util.*;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class Account {
    private int balance;

    Account(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount);
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class Transaction implements Comparable<Transaction> {
    int priority;
    String type;
    int amount;

    Transaction(int priority, String type, int amount) {
        this.priority = priority;
        this.type = type;
        this.amount = amount;
    }

    public int compareTo(Transaction other) {
        return other.priority - this.priority;
    }
}

public class ConcurrentBankSystem {
    public static void main(String[] args) {
        Account account = new Account(5000);

        PriorityQueue<Transaction> pq = new PriorityQueue<>();
        pq.add(new Transaction(2, "withdraw", 2000));
        pq.add(new Transaction(5, "deposit", 3000));
        pq.add(new Transaction(1, "withdraw", 7000));
        pq.add(new Transaction(4, "withdraw", 1000));

        while (!pq.isEmpty()) {
            Transaction tx = pq.poll();

            Thread t = new Thread(() -> {
                try {
                    if (tx.type.equals("withdraw")) {
                        account.withdraw(tx.amount);
                    } else {
                        account.deposit(tx.amount);
                    }
                } catch (InsufficientBalanceException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            });

            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
