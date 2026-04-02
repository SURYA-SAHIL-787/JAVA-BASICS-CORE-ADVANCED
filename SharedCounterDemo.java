import java.util.Scanner;
class SharedCounter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
public class SharedCounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter increments for Thread 1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter increments for Thread 2: ");
        int n2 = sc.nextInt();
        SharedCounter counter = new SharedCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < n1; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < n2; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final value: " + counter.getCount());
        sc.close();
    }
}