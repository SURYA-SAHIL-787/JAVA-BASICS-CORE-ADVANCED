import java.util.Scanner;

public class DeadlockDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sleep time in milliseconds: ");
        int delay = sc.nextInt();

        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 locked lock1");

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                synchronized (lock2) {
                    System.out.println("Thread 1 locked lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 locked lock2");

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                synchronized (lock1) {
                    System.out.println("Thread 2 locked lock1");
                }
            }
        });

        t1.start();
        t2.start();

        sc.close();
    }
}